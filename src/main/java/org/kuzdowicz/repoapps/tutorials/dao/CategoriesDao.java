package org.kuzdowicz.repoapps.tutorials.dao;

import java.util.List;

import org.kuzdowicz.repoapps.tutorials.models.Category;

public interface CategoriesDao {

	List<Category> getAllCategories();

	Category getOneById(Long pk);

	Category getOneByIdWithTutorials(Long pk);

	void saveOrUpdateTutorialCategory(Category tutorial);

	void deleteTutorialCategory(Category tutorial);

	List<String> getAllUserCategoriesNames(Long userId);

	List<Category> getAllUserCategories(Long userId);

}
