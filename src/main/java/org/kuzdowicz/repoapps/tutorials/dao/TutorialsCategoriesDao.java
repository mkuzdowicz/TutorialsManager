package org.kuzdowicz.repoapps.tutorials.dao;

import java.util.List;

import org.kuzdowicz.repoapps.tutorials.models.TutorialCategory;

public interface TutorialsCategoriesDao {

	List<TutorialCategory> getAllCategories();

	TutorialCategory getOneById(String pk);

	void saveOrUpdateTutorialCategory(TutorialCategory tutorial);

	void deleteTutorialCategory(TutorialCategory tutorial);

	List<String> getAllCategoriesNames();

}
