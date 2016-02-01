package org.kuzdowicz.repoapps.tutorials.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.kuzdowicz.repoapps.tutorials.model.Tutorial;
import org.kuzdowicz.repoapps.tutorials.service.TutorialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserPlanForCurrentWeekController {

	private final static Logger logger = Logger.getLogger(HomeController.class);

	@Autowired
	TutorialsService tutorialsService;

	@RequestMapping(value = "/tutorials-to-do", method = RequestMethod.GET)
	public ModelAndView tutorialsToDo() {

		logger.debug("tutorialsToDo()");

		ModelAndView mav = new ModelAndView("UserPlanForCurrentWeek");

		List<Tutorial> tutorialsToDoForCurrentWeek = tutorialsService.getTutorialsToDoForCurrentWeek();

		mav.addObject("tutorialsToDo", tutorialsToDoForCurrentWeek);

		return mav;
	}

}
