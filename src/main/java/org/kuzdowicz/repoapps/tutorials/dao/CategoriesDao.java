package org.kuzdowicz.repoapps.tutorials.dao;

import java.util.List;

import org.kuzdowicz.repoapps.tutorials.models.Category;

public interface CategoriesDao extends BasicCrudDao<Long, Category> {

	Category getOneByIdWithTutorials(Long pk);

	List<String> getAllUserCategoriesNames(Long userId);

	List<Category> getAllUserCategories(Long userId);

}
