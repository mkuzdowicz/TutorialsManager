package org.kuzdowicz.repoapps.tutorials.controllers;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.kuzdowicz.repoapps.tutorials.service.TutorialsCategoriesService;
import org.kuzdowicz.repoapps.tutorials.service.TutorialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class TutorialCRUDController {

	private final static Logger logger = Logger.getLogger(TutorialCRUDController.class);

	private TutorialsService tutorialsService;

	private TutorialsCategoriesService tutorialsCategoriesService;

	@Autowired
	public TutorialCRUDController(TutorialsService tutorialsService,
			TutorialsCategoriesService tutorialsCategoriesService) {
		this.tutorialsService = tutorialsService;
		this.tutorialsCategoriesService = tutorialsCategoriesService;
	}

	@RequestMapping(value = "/add-tutorial", method = RequestMethod.GET)
	public ModelAndView showAddTutoriaForm() {

		logger.debug("showAddTutoriaForm()");

		ModelAndView mav = new ModelAndView("AddTutorialsAndCategorisPage");

		List<String> categoriesNamesList = tutorialsCategoriesService.getCategoriesNamesList();
		mav.addObject("categories", categoriesNamesList);

		return mav;
	}

	@RequestMapping(value = "/add-tutorial", method = RequestMethod.POST)
	public String addTutorial(@RequestParam Map<String, String> reqMap) {

		logger.debug("addTutorial()");

		tutorialsService.saveNewTutorialByPostReq(reqMap);

		return "redirect:all-categories?name=" + reqMap.get("category");
	}

	@RequestMapping(value = "/edit-tutorial", method = RequestMethod.POST)
	public String editTutorial(@RequestParam Map<String, String> reqMap) {

		logger.debug("editTutorial()");

		tutorialsService.editTutorialByPostReq(reqMap);

		return "redirect:all-categories?name=" + reqMap.get("category");
	}

	@RequestMapping(value = "/remove-tutorial", method = RequestMethod.POST)
	public String removeTutorial(@RequestParam("tutorialId") Long id) {

		logger.debug("editTutorial()");

		System.out.println(id);

		String categoryNameOfRemovedTutorial = tutorialsService.getOneById(id).getTutorialCategory().getCategoryName();

		tutorialsService.removeOneById(id);

		return "redirect:all-categories?name=" + categoryNameOfRemovedTutorial;
	}

}
