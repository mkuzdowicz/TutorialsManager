package org.kuzdowicz.repoapps.tutorials.controllers;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.kuzdowicz.repoapps.tutorials.constants.UserTypes;
import org.kuzdowicz.repoapps.tutorials.dao.UsersDao;
import org.kuzdowicz.repoapps.tutorials.forms.CreateAccountForm;
import org.kuzdowicz.repoapps.tutorials.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
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

	private UsersDao usersDao;
	private PasswordEncoder passwordEncoder;
	private final ProviderSignInUtils providerSignInUtils;

	@Autowired
	public CreateAccountController(UsersDao usersDao, PasswordEncoder passwordEncoder,
			ConnectionFactoryLocator connectionFactoryLocator, UsersConnectionRepository connectionRepository) {
		this.usersDao = usersDao;
		this.passwordEncoder = passwordEncoder;
		this.providerSignInUtils = new ProviderSignInUtils(connectionFactoryLocator, connectionRepository);
	}

	@RequestMapping(value = "/create-account", method = RequestMethod.GET)
	public ModelAndView createAccountForm(String errorMsg, WebRequest request) {

		CreateAccountForm createAccountForm = new CreateAccountForm();

		Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);

		if (connection != null) {
			UserProfile userProfile = connection.fetchUserProfile();
			createAccountForm.setLogin(userProfile.getEmail());
			logger.debug(userProfile.getUsername());
		}

		ModelAndView mav = new ModelAndView("CreateAccountPage");
		mav.addObject("createAccountForm", createAccountForm);
		mav.addObject("errorMsg", errorMsg);
		return mav;
	}

	@RequestMapping(value = "/create-account", method = RequestMethod.POST)
	public ModelAndView createAccount(@Valid @ModelAttribute("createAccountForm") CreateAccountForm createAccountForm,
			BindingResult result) {

		String username = createAccountForm.getLogin();
		String password = createAccountForm.getPassword();
		String confirmPassword = createAccountForm.getConfirmPassword();

		ModelAndView mav = new ModelAndView("CreateAccountPage");
		if (result.hasErrors()) {
			mav.addObject("createAccountForm", createAccountForm);
			return mav;
		}

		if (!password.equals(confirmPassword)) {
			return createAccountForm("password and confirm password have to be equal", null);
		}

		AppUser newUser = new AppUser();
		newUser.setUsername(username);
		newUser.setPassword(passwordEncoder.encode(password));
		newUser.setType(UserTypes.USER);
		usersDao.saveOrUpdate(newUser);

		mav.addObject("successMsg", "user " + username + " created successfully");
		return mav;
	}

}
