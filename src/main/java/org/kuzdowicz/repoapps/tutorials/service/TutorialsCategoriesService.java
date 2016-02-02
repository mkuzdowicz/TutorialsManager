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

	public TutorialCategory getOneByName(String categoryName) {

		return tutorialsCategoriesDao.getOneById(categoryName);

	}

	public List<String> getCategoriesNamesList() {

		List<String> allCategories = tutorialsCategoriesDao.getAllCategoriesNames();

		return allCategories;

	}

	public void insertOrUpdate(TutorialCategory category) {

		tutorialsCategoriesDao.saveOrUpdateTutorialCategory(category);

	}

	public void insertOrUpdateWithGivenName(String categoryName) {

		TutorialCategory category = getOneByName(categoryName);

		if (category == null) {

			category = new TutorialCategory();
			category.setCategoryName(categoryName);
			insertOrUpdate(category);
		}

	}

}
