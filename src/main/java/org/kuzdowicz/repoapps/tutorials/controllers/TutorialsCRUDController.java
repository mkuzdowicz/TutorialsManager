package org.kuzdowicz.repoapps.tutorials.controllers;

import java.security.Principal;
import java.util.Map;

import org.apache.log4j.Logger;
import org.kuzdowicz.repoapps.tutorials.services.CategoriesService;
import org.kuzdowicz.repoapps.tutorials.services.TutorialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class TutorialsCRUDController {

	private final static Logger logger = Logger.getLogger(TutorialsCRUDController.class);

	private TutorialsService tutorialsService;
	private CategoriesService tutorialsCategoriesService;

	@Autowired
	public TutorialsCRUDController(TutorialsService tutorialsService, CategoriesService tutorialsCategoriesService) {
		this.tutorialsService = tutorialsService;
		this.tutorialsCategoriesService = tutorialsCategoriesService;
	}

	@RequestMapping(value = "/add-tutorial", method = RequestMethod.GET)
	public ModelAndView showAddTutoriaForm(Principal principal) {

		logger.debug("showAddTutoriaForm()");
		ModelAndView mav = new ModelAndView("AddTutorialsAndCategorisPage");
		mav.addObject("categories", tutorialsCategoriesService.getUserCategories(principal.getName()));

		return mav;
	}

	@RequestMapping(value = "/add-tutorial", method = RequestMethod.POST)
	public String addTutorial(@RequestParam Map<String, String> reqMap, Principal principal) {

		logger.debug("addTutorial()");
		tutorialsService.saveNewTutorialByPostReq(reqMap, principal);
		return "redirect:all-categories?name=" + reqMap.get("category");
	}

	@RequestMapping(value = "/edit-tutorial", method = RequestMethod.POST)
	public String editTutorial(@RequestParam Map<String, String> reqMap, Principal principal) {

		logger.debug("editTutorial()");
		tutorialsService.editTutorialByPostReq(reqMap);
		return "redirect:all-categories?name=" + reqMap.get("category");
	}

	@RequestMapping(value = "/remove-tutorial", method = RequestMethod.POST)
	public String removeTutorial(@RequestParam("tutorialId") Long id) {

		logger.debug("editTutorial()");
		String categoryNameOfRemovedTutorial = tutorialsService.getOneById(id).getTutorialCategory().getCategoryName();
		tutorialsService.removeOneById(id);
		return "redirect:all-categories?name=" + categoryNameOfRemovedTutorial;
	}

}
