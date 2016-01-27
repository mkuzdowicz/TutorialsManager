package org.kuzdowicz.repoapps.tutorials.controllers;

import org.kuzdowicz.repoapps.tutorials.service.TutorialsCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoriesPageController {

	@Autowired
	TutorialsCategoriesService tutorialsCategoriesService;

	@RequestMapping(value = "/all-categories", method = RequestMethod.GET)
	public ModelAndView printCategories() {

		ModelAndView mav = new ModelAndView("Categories");

		mav.addObject("catList", tutorialsCategoriesService.getCategoriesNamesList());

		return mav;

	}

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ModelAndView printCategoriesWithParam(@RequestParam("name") String name) {

		ModelAndView mav = new ModelAndView("Categories");

		mav.addObject("catList", tutorialsCategoriesService.getCategoriesNamesList());

		mav.addObject("selectedCategory", tutorialsCategoriesService.getOneByName(name));

		return mav;

	}

}
