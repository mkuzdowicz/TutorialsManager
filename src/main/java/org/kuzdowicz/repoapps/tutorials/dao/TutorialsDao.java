package org.kuzdowicz.repoapps.tutorials.dao;

import java.util.Date;
import java.util.List;

import org.kuzdowicz.repoapps.tutorials.model.Tutorial;

public interface TutorialsDao {

	public List<Tutorial> getAllTutorials();

	public List<Tutorial> getAllTutorialsBeetwenGivenDates(Date startDate, Date endDate);

	public Tutorial getOneById(Long pk);

	public void saveOrUpdateTutorial(Tutorial tutorial);

	public void deleteTutorial(Tutorial tutorial);

}
