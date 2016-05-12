package org.kuzdowicz.repoapps.tutorials.controllers;

import java.security.Principal;
import java.util.Map;

import org.apache.log4j.Logger;
import org.kuzdowicz.repoapps.tutorials.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/user")
public class CategoriesCRUDController {

	private final static Logger logger = Logger.getLogger(CategoriesCRUDController.class);
	private CategoriesService categoriesService;

	@Autowired
	public CategoriesCRUDController(CategoriesService tutorialsCategoriesService) {
		this.categoriesService = tutorialsCategoriesService;
	}

	@RequestMapping(value = "/add-category", method = RequestMethod.POST)
	public String addNewCategory(@RequestParam Map<String, String> reqMap, Principal principal) {

		logger.debug("addNewCategory()");
		String categoryName = reqMap.get("categoryName").trim();
		categoriesService.saveNewCategoryIfNotExistFotGivenNameAndUser(categoryName, principal);
		return "redirect:add-tutorial";
	}

	@RequestMapping(value = "/remove-category", method = RequestMethod.POST)
	public String removeCategory(@RequestParam("categoryPK") Long categoryPK, Principal principal) {

		logger.debug("removeCategory()");
		categoriesService.removeOneByPk(categoryPK);
		return "redirect:all-categories";
	}

}
