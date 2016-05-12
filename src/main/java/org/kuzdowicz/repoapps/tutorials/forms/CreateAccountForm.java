package org.kuzdowicz.repoapps.tutorials.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateAccountForm {

	@NotNull(message = "please enter a login")
	@Size(min = 4, max = 12, message = "your login should be between 4 - 12 characters")
	private String login;
	@NotNull(message = "please enter a login")
	@Size(min = 8, message = "password should be min 8 characters")
	private String password;
	@NotNull(message = "please enter a login")
	@Size(min = 8, message = "password should be min 8 characters")
	private String confirmPassword;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
