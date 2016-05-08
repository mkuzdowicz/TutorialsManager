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

	@Override
	public List<Tutorial> getAllTutorials() {

		return findAll();
	}

	@Override
	public Tutorial getOneById(Long pk) {

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Tutorial> getAllTutorialsBeetwenGivenDates(Date startDate, Date endDate) {

		Criteria criteria = getSession().createCriteria(Tutorial.class);

		LogicalExpression le = Restrictions.or(Restrictions.ge("startDateToDo", startDate),
				Restrictions.le("endDateToDo", endDate));

		criteria.add(le);

		return criteria.list();
	}

}
