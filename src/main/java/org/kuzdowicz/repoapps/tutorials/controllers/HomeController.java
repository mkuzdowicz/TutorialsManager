package org.kuzdowicz.repoapps.tutorials.controllers;

import org.apache.log4j.Logger;
import org.kuzdowicz.repoapps.tutorials.service.InitForTestService;
import org.kuzdowicz.repoapps.tutorials.service.TutorialsCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	TutorialsCategoriesService tutorialsCategoriesService;

	@Autowired
	InitForTestService initForTestService;

	private final static Logger logger = Logger.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homePage() {

		logger.debug("homePage");

		ModelAndView mav = new ModelAndView("Home");

		initForTestService.initSomeData();

		mav.addObject("categories", tutorialsCategoriesService.selectAll());

		return mav;
	}

}
