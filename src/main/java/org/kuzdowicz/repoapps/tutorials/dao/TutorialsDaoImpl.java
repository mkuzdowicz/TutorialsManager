package org.kuzdowicz.repoapps.tutorials.dao;

import java.util.List;

import org.kuzdowicz.repoapps.tutorials.model.Tutorial;

public class TutorialsDaoImpl extends AbstractDao<Integer, Tutorial> implements TutorialsDao {

	@Override
	public List<Tutorial> getAllTutorials() {

		return findAll();
	}

	@Override
	public Tutorial getOneById(Integer pk) {

		return findOne(pk);
	}

	@Override
	public void saveOrUpdateTutorial(Tutorial tutorial) {

		saveOrUpdate(tutorial);
	}

	@Override
	public void deleteTutorial(Tutorial tutorial) {
		
		delete(tutorial);

	}

}
