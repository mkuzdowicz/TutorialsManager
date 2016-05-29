package org.kuzdowicz.repoapps.tutorials.controllers;

import javax.validation.Valid;

import org.kuzdowicz.repoapps.tutorials.forms.CreateAccountForm;
import org.kuzdowicz.repoapps.tutorials.models.AppUser;
import org.kuzdowicz.repoapps.tutorials.security.AuthenticateUserAfterRegistrationService;
import org.kuzdowicz.repoapps.tutorials.services.ApplicationUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
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

	private final ApplicationUsersService applicationUsersService;
	private final ProviderSignInUtils providerSignInUtils;
	private final AuthenticateUserAfterRegistrationService authenticateUserAfterRegistrationService;

	@Autowired
	public CreateAccountController(ApplicationUsersService applicationUsersService,
			AuthenticateUserAfterRegistrationService authenticateUserAfterRegistrationService,
			ConnectionFactoryLocator connectionFactoryLocator, UsersConnectionRepository connectionRepository) {

		this.applicationUsersService = applicationUsersService;
		this.providerSignInUtils = new ProviderSignInUtils(connectionFactoryLocator, connectionRepository);
		this.authenticateUserAfterRegistrationService = authenticateUserAfterRegistrationService;
	}

	@RequestMapping(value = "/create-account", method = RequestMethod.GET)
	public ModelAndView createAccountForm(CreateAccountForm createAccountForm, String errorMsg, WebRequest request) {

		Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);

		createAccountForm.fillFormFromSocialProvider(connection);

		ModelAndView mav = new ModelAndView("CreateAccountPage");
		mav.addObject("createAccountForm", createAccountForm);
		mav.addObject("errorMsg", errorMsg);
		return mav;
	}

	@RequestMapping(value = "/create-account", method = RequestMethod.POST)
	public ModelAndView createAccount(@Valid @ModelAttribute("createAccountForm") CreateAccountForm createAccountForm,
			BindingResult result, WebRequest request) {

		String password = createAccountForm.getPassword();
		String confirmPassword = createAccountForm.getConfirmPassword();

		ModelAndView mav = new ModelAndView("CreateAccountPage");
		if (result.hasErrors()) {
			mav.addObject("createAccountForm", createAccountForm);
			return mav;
		}

		if (!password.equals(confirmPassword)) {
			createAccountForm.setPassword(null);
			createAccountForm.setConfirmPassword(null);
			return createAccountForm(createAccountForm, "password and confirm password have to be equal", request);
		}

		AppUser newAccount = applicationUsersService.createNewAccount(createAccountForm);
		if (newAccount == null) {
			return createAccountForm(new CreateAccountForm(), "login already in use!", request);
		}

		authenticateUserAfterRegistrationService.authenticateUser(newAccount);
		if (createAccountForm.isSocialSignin()) {
			providerSignInUtils.doPostSignUp(newAccount.getUsername(), request);
		}
		ModelAndView redirectAfterSuccessRegitsrationMAV = new ModelAndView("AddTutorialsAndCategorisPage");
		return redirectAfterSuccessRegitsrationMAV;
	}

}
