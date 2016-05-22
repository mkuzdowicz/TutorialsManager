package org.kuzdowicz.repoapps.tutorials.controllers;

import javax.validation.Valid;

import org.kuzdowicz.repoapps.tutorials.dao.UsersDao;
import org.kuzdowicz.repoapps.tutorials.forms.CreateAccountForm;
import org.kuzdowicz.repoapps.tutorials.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CreateAccountController {

	private UsersDao usersDao;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public CreateAccountController(UsersDao usersDao, PasswordEncoder passwordEncoder) {
		this.usersDao = usersDao;
		this.passwordEncoder = passwordEncoder;
	}

	@RequestMapping(value = "/create-account", method = RequestMethod.GET)
	public ModelAndView createAccountForm(String errorMsg) {

		CreateAccountForm createAccountForm = new CreateAccountForm();
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
			return createAccountForm("password and confirm password have to be equal");
		}

		AppUser newUser = new AppUser();
		newUser.setUsername(username);
		newUser.setPassword(passwordEncoder.encode(password));
		newUser.setType("ROLE_USER");
		usersDao.saveOrUpdate(newUser);

		mav.addObject("successMsg", "user " + username + " created successfully");
		return mav;
	}

}
