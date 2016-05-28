package org.kuzdowicz.repoapps.tutorials.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.kuzdowicz.repoapps.tutorials.constants.SocialProviders;
import org.kuzdowicz.repoapps.tutorials.constants.UserTypes;
import org.kuzdowicz.repoapps.tutorials.dao.UsersDao;
import org.kuzdowicz.repoapps.tutorials.forms.CreateAccountForm;
import org.kuzdowicz.repoapps.tutorials.models.AppUser;
import org.kuzdowicz.repoapps.tutorials.security.AuthenticateUserAfterRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CreateAccountController {

	private final static Logger logger = Logger.getLogger(CreateAccountController.class);

	private final UsersDao usersDao;
	private final PasswordEncoder passwordEncoder;
	private final ProviderSignInUtils providerSignInUtils;
	private final AuthenticateUserAfterRegistrationService authenticateUserAfterRegistrationService;

	@Autowired
	public CreateAccountController(UsersDao usersDao, PasswordEncoder passwordEncoder,
			AuthenticateUserAfterRegistrationService authenticateUserAfterRegistrationService,
			ConnectionFactoryLocator connectionFactoryLocator, UsersConnectionRepository connectionRepository) {

		this.usersDao = usersDao;
		this.passwordEncoder = passwordEncoder;
		this.providerSignInUtils = new ProviderSignInUtils(connectionFactoryLocator, connectionRepository);
		this.authenticateUserAfterRegistrationService = authenticateUserAfterRegistrationService;
	}

	@RequestMapping(value = "/create-account", method = RequestMethod.GET)
	public ModelAndView createAccountForm(CreateAccountForm createAccountForm, String errorMsg, WebRequest request) {

		Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);

		if (connection != null) {
			ConnectionKey connKey = connection.getKey();

			UserProfile userProfile = connection.fetchUserProfile();
			String socialProviderId = connKey.getProviderId();

			if (socialProviderId.equals(SocialProviders.facebook.name())) {
				createAccountForm.setLogin(userProfile.getEmail());
			}
			if (socialProviderId.equals(SocialProviders.twitter.name())) {
				createAccountForm.setLogin(connection.getDisplayName());
			}
			logger.debug(connection.getDisplayName());
			logger.debug(connKey.getProviderUserId());
		}

		ModelAndView mav = new ModelAndView("CreateAccountPage");
		mav.addObject("createAccountForm", createAccountForm);
		mav.addObject("errorMsg", errorMsg);
		return mav;
	}

	@RequestMapping(value = "/create-account", method = RequestMethod.POST)
	public ModelAndView createAccount(@Valid @ModelAttribute("createAccountForm") CreateAccountForm createAccountForm,
			BindingResult result, HttpServletRequest request, HttpServletRequest response) {

		String username = createAccountForm.getLogin();
		String password = createAccountForm.getPassword();
		String confirmPassword = createAccountForm.getConfirmPassword();

		ModelAndView mav = new ModelAndView("CreateAccountPage");
		if (result.hasErrors()) {
			mav.addObject("createAccountForm", createAccountForm);
			return mav;
		}

		if (!password.equals(confirmPassword)) {
			return createAccountForm(new CreateAccountForm(), "password and confirm password have to be equal", null);
		}

		AppUser newUser = new AppUser();
		newUser.setUsername(username);
		newUser.setPassword(passwordEncoder.encode(password));
		newUser.setType(UserTypes.USER);
		usersDao.saveOrUpdate(newUser);

		authenticateUserAfterRegistrationService.authenticateUser(newUser);

		ModelAndView redirectAfterSuccessRegitsrationMAV = new ModelAndView("AddTutorialsAndCategorisPage");
		return redirectAfterSuccessRegitsrationMAV;
	}

}
