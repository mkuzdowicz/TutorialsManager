package org.kuzdowicz.repoapps.tutorials.dao;

import java.util.List;

import org.kuzdowicz.repoapps.tutorials.model.Tutorial;

public interface TutorialsDao {

	public List<Tutorial> getAllTutorials();

	public Tutorial getOneById(Integer pk);

	public void saveOrUpdateTutorial(Tutorial tutorial);

	public void deleteTutorial(Tutorial tutorial);

}
