package org.kuzdowicz.repoapps.tutorials.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.kuzdowicz.repoapps.tutorials.models.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class CategoriesDaoImpl extends AbstractDao<Long, Category>
		implements CategoriesDao {

	@Override
	public List<Category> getAllCategories() {
		return findAll();
	}

	@Override
	public Category getOneById(Long pk) {
		return findOne(pk);
	}

	@Override
	public void saveOrUpdateTutorialCategory(Category tutorialCategory) {
		saveOrUpdate(tutorialCategory);
	}

	@Override
	public void deleteTutorialCategory(Category tutorialCategory) {
		delete(tutorialCategory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllUserCategoriesNames(Long userId) {
		Criteria criteria = getSession().createCriteria(Category.class);
		criteria.add(Restrictions.eq("userId", userId));
		criteria.setProjection(Projections.property("categoryName"));
		return criteria.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Category> getAllUserCategories(Long userId) {
		Criteria criteria = getSession().createCriteria(Category.class);
		criteria.add(Restrictions.eq("userId", userId));
		return criteria.list();
	}

}
