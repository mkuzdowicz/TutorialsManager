package org.kuzdowicz.repoapps.tutorials.dao;

import java.util.Date;
import java.util.List;

import org.kuzdowicz.repoapps.tutorials.models.UserTutorial;

public interface TutorialsDao {

	List<UserTutorial> getAllTutorials();

	List<UserTutorial> getAllTutorialsBeetwenGivenDates(Date startDate, Date endDate);

	UserTutorial getOneById(Long pk);

	void saveOrUpdateTutorial(UserTutorial tutorial);

	void deleteTutorial(UserTutorial tutorial);

	List<UserTutorial> getAllTutorialsBeetwenGivenDatesAndUserId(Date startDate, Date endDate, Long userId);

}
