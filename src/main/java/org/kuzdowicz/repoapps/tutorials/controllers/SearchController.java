package org.kuzdowicz.repoapps.tutorials.controllers;

import org.kuzdowicz.repoapps.tutorials.service.TutorialsCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {

	@Autowired
	TutorialsCategoriesService tutorialsCategoriesService;

	@RequestMapping(value = "/search")
	public ModelAndView findCategoryAllTutorials(@RequestParam("categoryName") String categoryName) {

		ModelAndView mav = new ModelAndView("SearchOne");

		mav.addObject("category", tutorialsCategoriesService.getOneByName(categoryName));

		return mav;

	}

}
