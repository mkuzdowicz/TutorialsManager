package org.kuzdowicz.repoapps.tutorials.dao;

import java.util.Date;
import java.util.List;

import org.kuzdowicz.repoapps.tutorials.models.Tutorial;

public interface TutorialsDao {

	List<Tutorial> getAllTutorials();

	List<Tutorial> getAllTutorialsBeetwenGivenDates(Date startDate, Date endDate);

	Tutorial getOneById(Long pk);

	void saveOrUpdateTutorial(Tutorial tutorial);

	void deleteTutorial(Tutorial tutorial);

}
