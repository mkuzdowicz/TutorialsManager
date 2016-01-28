package org.kuzdowicz.repoapps.tutorials.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlanForTutorialsController {

	private final static Logger logger = Logger.getLogger(HomeController.class);

	@RequestMapping(value = "/tutorials-to-do", method = RequestMethod.GET)
	public ModelAndView homePage() {

		logger.debug("homePage()");

		ModelAndView mav = new ModelAndView("UserPlanForTutorials");

		return mav;
	}

}
