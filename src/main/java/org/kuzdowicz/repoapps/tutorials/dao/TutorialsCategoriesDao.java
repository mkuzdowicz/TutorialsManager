package org.kuzdowicz.repoapps.tutorials.dao;

import java.util.List;

import org.kuzdowicz.repoapps.tutorials.model.TutorialCategory;

public interface TutorialsCategoriesDao {

	public List<TutorialCategory> getAllCategories();

	public TutorialCategory getOneById(String pk);

	public void saveOrUpdateTutorialCategory(TutorialCategory tutorial);

	public void deleteTutorialCategory(TutorialCategory tutorial);

	public List<String> getAllCategoriesNames();

}
