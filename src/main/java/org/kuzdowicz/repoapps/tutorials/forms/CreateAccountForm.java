package org.kuzdowicz.repoapps.tutorials.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.kuzdowicz.repoapps.tutorials.constants.SocialProvider;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.UserProfile;

public class CreateAccountForm {

	@NotNull(message = "please enter a login")
	@Size(min = 4, max = 30, message = "your login should be between 4 - 30 characters")
	private String login;
	@NotNull(message = "please enter a login")
	@Size(min = 8, message = "password should be min 8 characters")
	private String password;
	@NotNull(message = "please enter a login")
	@Size(min = 8, message = "password should be min 8 characters")
	private String confirmPassword;

	private SocialProvider socialProvider;

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

	public SocialProvider getSocialProvider() {
		return socialProvider;
	}

	public void setSocialProvider(SocialProvider socialProvider) {
		this.socialProvider = socialProvider;
	}

	public void fillFormFromSocialProvider(Connection<?> connection) {
		if (connection != null) {
			ConnectionKey connKey = connection.getKey();

			UserProfile userProfile = connection.fetchUserProfile();
			String socialProviderId = connKey.getProviderId();

			if (socialProviderId.equals(SocialProvider.facebook.name())) {
				this.setSocialProvider(SocialProvider.facebook);
				this.setLogin(userProfile.getEmail());
			}
			if (socialProviderId.equals(SocialProvider.twitter.name())) {
				this.setSocialProvider(SocialProvider.twitter);
				this.setLogin(connection.getDisplayName());
			}
		}
	}

	public boolean isSocialSignin() {
		return this.socialProvider != null;
	}

	@Override
	public String toString() {
		return "CreateAccountForm [login=" + login + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", socialProvider=" + socialProvider + "]";
	}

}
