package org.kuzdowicz.repoapps.tutorials.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.kuzdowicz.repoapps.tutorials.models.UserTutorialsCategory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class TutorialsCategoriesDaoImpl extends AbstractDao<String, UserTutorialsCategory>
		implements TutorialsCategoriesDao {

	@Override
	public List<UserTutorialsCategory> getAllCategories() {
		return findAll();
	}

	@Override
	public UserTutorialsCategory getOneById(String pk) {
		return findOne(pk);
	}

	@Override
	public void saveOrUpdateTutorialCategory(UserTutorialsCategory tutorialCategory) {
		saveOrUpdate(tutorialCategory);
	}

	@Override
	public void deleteTutorialCategory(UserTutorialsCategory tutorialCategory) {
		delete(tutorialCategory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllUserCategoriesNames(Long userId) {

		Criteria criteria = getSession().createCriteria(UserTutorialsCategory.class);
		criteria.add(Restrictions.eq("userId", userId));
		criteria.setProjection(Projections.property("categoryName"));
		return criteria.list();
	}

}
