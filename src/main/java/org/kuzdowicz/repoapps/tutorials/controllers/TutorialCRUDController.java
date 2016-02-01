package org.kuzdowicz.repoapps.tutorials.controllers;

import java.util.Map;

import org.apache.log4j.Logger;
import org.kuzdowicz.repoapps.tutorials.model.Tutorial;
import org.kuzdowicz.repoapps.tutorials.service.TutorialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TutorialCRUDController {

	private final static Logger logger = Logger.getLogger(TutorialCRUDController.class);

	@Autowired
	private TutorialsService tutorialsService;

	@RequestMapping(value = "/add-tutorial", method = RequestMethod.GET)
	public ModelAndView showAddTutoriaForm() {

		logger.debug("showAddTutoriaForm()");

		ModelAndView mav = new ModelAndView("AddTutorialPage");

		return mav;
	}

	@RequestMapping(value = "/add-tutorial", method = RequestMethod.POST)
	public ModelAndView addTutorial(@RequestParam Map<String, String> reqMap) {

		logger.debug("addTutorial()");

		ModelAndView mav = new ModelAndView("AddTutorialPage");

		tutorialsService.addTutorialByPostReq(reqMap);

		mav.addObject("reqMap", reqMap);

		return mav;
	}

	// AJAX REQUESTS

	@RequestMapping(value = "/edit-tutorial", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody Tutorial showEditTutorialForm(@RequestParam Long id) {

		logger.debug("editTutorial()");

		System.out.println(id);

		return tutorialsService.getOneById(id);
	}

}
