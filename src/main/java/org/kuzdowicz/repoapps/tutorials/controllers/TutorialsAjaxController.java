package org.kuzdowicz.repoapps.tutorials.controllers;

import org.apache.log4j.Logger;
import org.kuzdowicz.repoapps.tutorials.model.Tutorial;
import org.kuzdowicz.repoapps.tutorials.service.TutorialsService;
import org.kuzdowicz.repoaps.tutorials.dto.TutorialDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TutorialsAjaxController {

	private final static Logger logger = Logger.getLogger(TutorialsAjaxController.class);

	@Autowired
	private TutorialsService tutorialsService;

	@RequestMapping(value = "/edit-tutorial-show-form", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody TutorialDTO showEditTutorialForm(@RequestParam Long id) {

		logger.debug("showEditTutorialForm()");

		Tutorial tutorialDataToEdit = tutorialsService.getOneById(id);

		TutorialDTO tutorialEditDto = new TutorialDTO();
		tutorialEditDto.setId(tutorialDataToEdit.getId());
		tutorialEditDto.setTitle(tutorialDataToEdit.getTitle());
		tutorialEditDto.setUrl(tutorialDataToEdit.getUrl());
		tutorialEditDto.setAuthor(tutorialDataToEdit.getAuthor());
		tutorialEditDto.setServiceDomain(tutorialDataToEdit.getServiceDomain());
		tutorialEditDto.setRating(tutorialDataToEdit.getRating());
		tutorialEditDto.setProgress(tutorialDataToEdit.getProgress());
		tutorialEditDto.setStartDateToDo(tutorialDataToEdit.getStartDateToDo());
		tutorialEditDto.setEndDateToDo(tutorialDataToEdit.getEndDateToDo());
		tutorialEditDto.setCategryName(tutorialDataToEdit.getTutorialCategory().getCategoryName());

		return tutorialEditDto;
	}

	@RequestMapping(value = "/tutorial-rating-increment", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody TutorialDTO incrementTutorialRating(@RequestParam Long id) {

		logger.debug("incrementTutorialRating()");

		Tutorial tutorialWithIncrementedRating = tutorialsService.incremetRatingAndReturnChangedObject(id);
		TutorialDTO tutorialDTO = new TutorialDTO();
		tutorialDTO.setRating(tutorialWithIncrementedRating.getRating());

		return tutorialDTO;

	}

	@RequestMapping(value = "/tutorial-rating-decrement", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody TutorialDTO decrementTutorialRating(@RequestParam Long id) {

		logger.debug("decrementTutorialRating()");

		Tutorial tutorialWithDecrementedRating = tutorialsService.decrementRatingAndReturnChangedObject(id);
		TutorialDTO tutorialDTO = new TutorialDTO();
		tutorialDTO.setRating(tutorialWithDecrementedRating.getRating());

		return tutorialDTO;

	}

	@RequestMapping(value = "/tutorial-progress-increment", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody TutorialDTO incrementTutorialProgress(@RequestParam Long id) {

		logger.debug("decrementTutorialRating()");

		Tutorial tutorialWithDecrementedProgress = tutorialsService.incremetTutorialProgressAndReturnChangedObject(id);
		TutorialDTO tutorialDTO = new TutorialDTO();
		tutorialDTO.setProgress(tutorialWithDecrementedProgress.getProgress());

		return tutorialDTO;

	}

	@RequestMapping(value = "/tutorial-progress-decrement", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody TutorialDTO decrementTutorialProgress(@RequestParam Long id) {

		logger.debug("decrementTutorialRating()");

		Tutorial tutorialWithDecrementedProgress = tutorialsService.decremetTutorialProgressAndReturnChangedObject(id);
		TutorialDTO tutorialDTO = new TutorialDTO();
		tutorialDTO.setProgress(tutorialWithDecrementedProgress.getProgress());

		return tutorialDTO;

	}

}
