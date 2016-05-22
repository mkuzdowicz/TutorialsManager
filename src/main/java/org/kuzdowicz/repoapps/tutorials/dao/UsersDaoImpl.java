package org.kuzdowicz.repoapps.tutorials.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.kuzdowicz.repoapps.tutorials.models.AppUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UsersDaoImpl extends AbstractDao<Long, AppUser> implements UsersDao {

	@Override
	public AppUser findOneUserByUsername(String username) {

		Session session = getSession();
		Criteria AppUserCriteria = session.createCriteria(AppUser.class);
		AppUserCriteria.add(Restrictions.eq("username", username));

		return (AppUser) AppUserCriteria.uniqueResult();
	}

}
