package org.kuzdowicz.repoapps.tutorials.dao;

import java.util.Date;
import java.util.List;

import org.kuzdowicz.repoapps.tutorials.models.Tutorial;

public interface TutorialsDao extends BasicCrudDao<Long, Tutorial> {

	List<Tutorial> getAllTutorialsBeetwenGivenDates(Date startDate, Date endDate);

	List<Tutorial> getAllTutorialsBeetwenGivenDatesAndUserId(Date startDate, Date endDate, Long userId);

}
