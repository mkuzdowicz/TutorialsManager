package org.kuzdowicz.repoapps.tutorials.service;

import java.util.List;

import org.kuzdowicz.repoapps.tutorials.dao.TutorialsCategoriesDao;
import org.kuzdowicz.repoapps.tutorials.model.TutorialCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorialsCategoriesService {

	@Autowired
	private TutorialsCategoriesDao tutorialsCategoriesDao;

	public List<TutorialCategory> selectAll() {

		return tutorialsCategoriesDao.getAllCategories();

	}

}
