package org.kuzdowicz.repoapps.tutorials.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.kuzdowicz.repoapps.tutorials.models.Tutorial;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class TutorialsDaoImpl extends AbstractDao<Long, Tutorial> implements TutorialsDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Tutorial> getAllTutorialsBeetwenGivenDates(Date startDate, Date endDate) {

		Criteria criteria = getSession().createCriteria(Tutorial.class);

		LogicalExpression le = Restrictions.or(Restrictions.ge("startDateToDo", startDate),
				Restrictions.le("endDateToDo", endDate));

		criteria.add(le);

		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tutorial> getAllTutorialsBeetwenGivenDatesAndUserId(Date startDate, Date endDate, Long userId) {

		Criteria criteria = getSession().createCriteria(Tutorial.class);

		LogicalExpression beetwenDatesExp = Restrictions.or(Restrictions.ge("startDateToDo", startDate),
				Restrictions.le("endDateToDo", endDate));

		criteria.add(Restrictions.and(beetwenDatesExp, Restrictions.eq("userId", userId)));

		return criteria.list();
	}

}
