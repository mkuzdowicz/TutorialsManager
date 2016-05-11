package org.kuzdowicz.repoapps.tutorials.dao;

import java.util.List;

import org.kuzdowicz.repoapps.tutorials.models.UserTutorialsCategory;

public interface TutorialsCategoriesDao {

	List<UserTutorialsCategory> getAllCategories();

	UserTutorialsCategory getOneById(String pk);

	void saveOrUpdateTutorialCategory(UserTutorialsCategory tutorial);

	void deleteTutorialCategory(UserTutorialsCategory tutorial);

	List<String> getAllUserCategoriesNames(Long userId);

}
