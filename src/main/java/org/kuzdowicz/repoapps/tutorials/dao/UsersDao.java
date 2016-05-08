package org.kuzdowicz.repoapps.tutorials.dao;

import java.util.List;

import org.kuzdowicz.repoapps.tutorials.models.AppUser;

public interface UsersDao {
	
	List<AppUser> findAllUsers();
	
	AppUser findOneUserById(Long id);
	
	AppUser findOneUserByUsername(String username);
	
	void deleteUser(AppUser user);
	
	void saveOrUpdateUser(AppUser user);

}
