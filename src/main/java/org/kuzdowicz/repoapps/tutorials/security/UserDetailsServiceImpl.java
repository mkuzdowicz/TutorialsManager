package org.kuzdowicz.repoapps.tutorials.security;

import org.kuzdowicz.repoapps.tutorials.dao.UsersDao;
import org.kuzdowicz.repoapps.tutorials.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UsersDao usersDao;

	@Autowired
	public UserDetailsServiceImpl(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		AppUser user = usersDao.findOneUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException(username + " login not found");
		}

		return new UserDetailsImpl(user);
	}

}
