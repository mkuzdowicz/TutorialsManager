package org.kuzdowicz.repoapps.tutorials.controllers;

import java.util.Map;

import org.apache.log4j.Logger;
import org.kuzdowicz.repoapps.tutorials.service.TutorialsCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryCRUDController {

	private final static Logger logger = Logger.getLogger(CategoryCRUDController.class);

	@Autowired
	private TutorialsCategoriesService tutorialsCategoriesService;

	@RequestMapping(value = "/add-category", method = RequestMethod.POST)
	public String addNewCategory(@RequestParam Map<String, String> reqMap) {

		logger.debug("addNewCategory()");

		String categoryName = reqMap.get("categoryName").trim();
		tutorialsCategoriesService.insertOrUpdateWithGivenName(categoryName);

		return "redirect:add-tutorial";
	}

	@RequestMapping(value = "/remove-category", method = RequestMethod.POST)
	public String removeCategory(@RequestParam("categoryPK") String categoryPK) {

		logger.debug("removeCategory()");

		tutorialsCategoriesService.removeOneByPk(categoryPK);

		return "redirect:all-categories";
	}

}
