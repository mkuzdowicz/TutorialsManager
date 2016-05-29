package org.kuzdowicz.repoapps.tutorials.controllers;

import org.kuzdowicz.repoapps.tutorials.services.ApplicationUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminPanel {

	private ApplicationUsersService applicationUsersService;

	@Autowired
	public AdminPanel(ApplicationUsersService applicationUsersService) {
		this.applicationUsersService = applicationUsersService;
	}

	@RequestMapping(value = "/admin/users", method = RequestMethod.GET)
	public ModelAndView showUsersTablePage() {

		ModelAndView mav = new ModelAndView("admin/UsersTable");
		mav.addObject("users", applicationUsersService.allUsers());

		return mav;
	}

}
