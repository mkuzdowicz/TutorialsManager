package org.kuzdowicz.repoapps.tutorials.dao;

import org.kuzdowicz.repoapps.tutorials.models.AppUser;

public interface UsersDao extends BasicCrudDao<Long, AppUser> {

	AppUser findOneUserByUsername(String username);
	
	AppUser findByFacebookId(String facebookId);

}
