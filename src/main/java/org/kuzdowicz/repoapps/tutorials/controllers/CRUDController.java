package org.kuzdowicz.repoapps.tutorials.controllers;

import java.util.Map;

import org.apache.log4j.Logger;
import org.kuzdowicz.repoapps.tutorials.service.TutorialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CRUDController {

	private final static Logger logger = Logger.getLogger(CRUDController.class);

	@Autowired
	private TutorialsService tutorialsService;

	@RequestMapping(value = "/add-tutorial", method = RequestMethod.GET)
	public ModelAndView showAddTutoriaForm() {

		logger.debug("showAddTutoriaForm()");

		ModelAndView mav = new ModelAndView("AddTutorialPage");

		return mav;
	}

	@RequestMapping(value = "/add-tutorial", method = RequestMethod.POST)
	public ModelAndView addTutoriaForm(@RequestParam Map<String, String> reqMap) {

		logger.debug("addTutoriaForm()");

		ModelAndView mav = new ModelAndView("AddTutorialPage");

		mav.addObject("reqMap", reqMap);

		return mav;
	}

}
