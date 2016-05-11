package org.kuzdowicz.repoapps.tutorials.controllers;

import java.security.Principal;

import org.kuzdowicz.repoapps.tutorials.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class TutorialsPageController {

	private CategoriesService categoriesService;

	@Autowired
	public TutorialsPageController(CategoriesService categoriesService) {
		this.categoriesService = categoriesService;
	}

	@RequestMapping(value = "/all-categories", method = RequestMethod.GET)
	public ModelAndView printCategoriesWithParam(@RequestParam(required = false) Long categoryId, Principal principal) {

		ModelAndView mav = new ModelAndView("Categories");

		mav.addObject("catList", categoriesService.getUserCategories(principal.getName()));

		if (categoryId != null) {
			mav.addObject("selectedCategory", categoriesService.getOneById(categoryId));
		}

		return mav;

	}

}