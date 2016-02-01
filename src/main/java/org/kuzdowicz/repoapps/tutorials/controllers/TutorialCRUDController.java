package org.kuzdowicz.repoapps.tutorials.controllers;

import java.util.Map;

import org.apache.log4j.Logger;
import org.kuzdowicz.repoapps.tutorials.model.Tutorial;
import org.kuzdowicz.repoapps.tutorials.service.TutorialsCategoriesService;
import org.kuzdowicz.repoapps.tutorials.service.TutorialsService;
import org.kuzdowicz.repoaps.dto.TutorialEditDto;
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

	@Autowired
	TutorialsCategoriesService tutorialsCategoriesService;

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

	@RequestMapping(value = "/edit-tutorial-show-form", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody TutorialEditDto showEditTutorialForm(@RequestParam Long id) {

		logger.debug("editTutorial()");

		System.out.println(id);

		Tutorial tutorialDataToEdit = tutorialsService.getOneById(id);

		TutorialEditDto tutorialEditDto = new TutorialEditDto();
		tutorialEditDto.setId(tutorialDataToEdit.getId());
		tutorialEditDto.setTitle(tutorialDataToEdit.getTitle());
		tutorialEditDto.setUrl(tutorialDataToEdit.getUrl());
		tutorialEditDto.setAuthor(tutorialDataToEdit.getAuthor());
		tutorialEditDto.setServiceDomain(tutorialDataToEdit.getServiceDomain());
		tutorialEditDto.setRating(tutorialDataToEdit.getRating());
		tutorialEditDto.setReworkedInPercents(tutorialDataToEdit.getReworkedInPercents());
		tutorialEditDto.setStartDateToDo(tutorialDataToEdit.getStartDateToDo());
		tutorialEditDto.setEndDateToDo(tutorialDataToEdit.getEndDateToDo());
		tutorialEditDto.setCategryName(tutorialDataToEdit.getTutorialCategory().getCategoryName());

		return tutorialEditDto;
	}

	@RequestMapping(value = "/remove-tutorial", method = RequestMethod.POST)
	public ModelAndView removeTutorial(@RequestParam("tutorialId") Long id) {

		logger.debug("editTutorial()");

		System.out.println(id);

		String categoryNameOfRemovedTutorial = tutorialsService.getOneById(id).getTutorialCategory().getCategoryName();

		tutorialsService.removeOneById(id);

		return printCategoriesWithParam(categoryNameOfRemovedTutorial);
	}

	private ModelAndView printCategoriesWithParam(@RequestParam("name") String name) {

		ModelAndView mav = new ModelAndView("Categories");

		mav.addObject("catList", tutorialsCategoriesService.getCategoriesNamesList());

		mav.addObject("selectedCategory", tutorialsCategoriesService.getOneByName(name));

		return mav;

	}

}
