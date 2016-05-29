package org.kuzdowicz.repoapps.tutorials.services;

import java.util.List;

import org.kuzdowicz.repoapps.tutorials.constants.UserRole;
import org.kuzdowicz.repoapps.tutorials.dao.UsersDao;
import org.kuzdowicz.repoapps.tutorials.forms.CreateAccountForm;
import org.kuzdowicz.repoapps.tutorials.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApplicationUsersService {

	private final UsersDao usersDao;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public ApplicationUsersService(UsersDao usersDao, PasswordEncoder passwordEncoder) {
		this.usersDao = usersDao;
		this.passwordEncoder = passwordEncoder;
	}

	@Transactional
	public AppUser createNewAccount(CreateAccountForm createAccountForm) {
		AppUser userByUsername = usersDao.findOneUserByUsername(createAccountForm.getLogin());
		if (userByUsername != null) {
			return null;
		}
		AppUser newUser = new AppUser();
		newUser.setUsername(createAccountForm.getLogin());
		newUser.setPassword(passwordEncoder.encode(createAccountForm.getPassword()));
		newUser.setType(UserRole.ROLE_USER);
		if (createAccountForm.isSocialSignin()) {
			newUser.setSignInProvider(createAccountForm.getSocialProvider());
		}
		usersDao.saveOrUpdate(newUser);
		return newUser;
	}

	public List<AppUser> allUsers() {
		return usersDao.findAll();
	}
	
	public void removeUser(Long pk){
		usersDao.delete(usersDao.findOne(pk));
	}

}
