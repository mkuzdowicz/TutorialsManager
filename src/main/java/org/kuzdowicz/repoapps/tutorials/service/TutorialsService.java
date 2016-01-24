package org.kuzdowicz.repoapps.tutorials.service;

import java.util.List;
import java.util.Map;

import org.kuzdowicz.repoapps.tutorials.dao.TutorialsCategoriesDao;
import org.kuzdowicz.repoapps.tutorials.dao.TutorialsDao;
import org.kuzdowicz.repoapps.tutorials.model.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorialsService {

	@Autowired
	private TutorialsDao tutorialsDao;

	@Autowired
	private TutorialsCategoriesDao tutorialsCategoriesDao;

	public List<Tutorial> selectAll() {

		return tutorialsDao.getAllTutorials();

	}

	public void addTutorialByPostReq(Map<String, String> reqParamsMap) {

	}

}
