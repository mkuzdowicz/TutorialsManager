package org.kuzdowicz.repoapps.tutorials.dao;

import java.util.List;

import org.kuzdowicz.repoapps.tutorials.model.TutorialCategory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class TutorialsCategoriesDaoImpl extends AbstractDao<Long, TutorialCategory> implements TutorialsCategoriesDao {

	@Override
	public List<TutorialCategory> getAllCategories() {

		return findAll();
	}

	@Override
	public TutorialCategory getOneById(Long pk) {

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

}
