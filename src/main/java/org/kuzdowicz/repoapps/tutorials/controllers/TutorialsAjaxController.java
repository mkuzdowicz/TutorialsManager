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

		logger.debug("editTutorial()");

		System.out.println(id);

		Tutorial tutorialDataToEdit = tutorialsService.getOneById(id);

		TutorialDTO tutorialEditDto = new TutorialDTO();
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

}
