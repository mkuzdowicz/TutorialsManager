package org.kuzdowicz.repoapps.tutorials.controllers;

import org.apache.log4j.Logger;
import org.kuzdowicz.repoapps.tutorials.service.InitStartDataForTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InitDBDataController {

	InitStartDataForTestService initForTestService;

	@Autowired
	public InitDBDataController(InitStartDataForTestService initForTestService) {
		this.initForTestService = initForTestService;
	}

	private final static Logger logger = Logger.getLogger(InitDBDataController.class);

	@RequestMapping(value = "/init-data", method = RequestMethod.GET)
	public ModelAndView initDataPage() {

		logger.debug("initDataPage()");

		ModelAndView mav = new ModelAndView("Home");

		initForTestService.initSomeData();

		return mav;
	}

}
