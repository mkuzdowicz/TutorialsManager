package org.kuzdowicz.repoapps.tutorials.services;

import java.util.List;

import org.kuzdowicz.repoapps.tutorials.dao.UsersDao;
import org.kuzdowicz.repoapps.tutorials.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUsersService {

	private UsersDao usersDao;

	@Autowired
	public ApplicationUsersService(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public AppUser createNewAccount(AppUser newUser) {
		AppUser userByUsername = usersDao.findOneUserByUsername(newUser.getUsername());
		if (userByUsername != null) {
			return null;
		}
		usersDao.saveOrUpdate(newUser);
		return newUser;
	}

	public List<AppUser> allUsers() {
		return usersDao.findAll();
	}

}
