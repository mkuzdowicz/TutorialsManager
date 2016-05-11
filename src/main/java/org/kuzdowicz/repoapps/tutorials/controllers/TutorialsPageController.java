package org.kuzdowicz.repoapps.tutorials.controllers;

import java.security.Principal;

import org.kuzdowicz.repoapps.tutorials.service.TutorialsCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class TutorialsPageController {

	private TutorialsCategoriesService tutorialsCategoriesService;

	@Autowired
	public TutorialsPageController(TutorialsCategoriesService tutorialsCategoriesService) {
		this.tutorialsCategoriesService = tutorialsCategoriesService;
	}

	@RequestMapping(value = "/all-categories", method = RequestMethod.GET)
	public ModelAndView printCategoriesWithParam(@RequestParam(required = false) String categoryName, Principal principal) {

		ModelAndView mav = new ModelAndView("Categories");

		mav.addObject("catList", tutorialsCategoriesService.getUserCategoriesNames(principal.getName()));

		if (categoryName != null) {
			mav.addObject("selectedCategory", tutorialsCategoriesService.getOneByName(categoryName));
		}

		return mav;

	}

}
