package org.kuzdowicz.repoapps.tutorials.dao;

import java.util.List;

import org.hibernate.criterion.Projections;
import org.kuzdowicz.repoapps.tutorials.models.TutorialCategory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class TutorialsCategoriesDaoImpl extends AbstractDao<String, TutorialCategory>
		implements TutorialsCategoriesDao {

	@Override
	public List<TutorialCategory> getAllCategories() {

		return findAll();
	}

	@Override
	public TutorialCategory getOneById(String pk) {

		return findOne(pk);
	}

	@Override
	public void saveOrUpdateTutorialCategory(TutorialCategory tutorialCategory) {

		saveOrUpdate(tutorialCategory);

	}

	@Override
	public void deleteTutorialCategory(TutorialCategory tutorialCategory) {

		delete(tutorialCategory);

	}

	@SuppressWarnings("unchecked")
	public List<String> getAllCategoriesNames() {

		return getSession().createCriteria(TutorialCategory.class).setProjection(Projections.property("categoryName"))
				.list();

	}

}
