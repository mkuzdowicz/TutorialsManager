package org.kuzdowicz.repoapps.tutorials.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.kuzdowicz.repoapps.tutorials.constants.SocialProvider;
import org.kuzdowicz.repoapps.tutorials.constants.UserRole;

@Entity
@Table(name = "USERS")
public class AppUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Long userid;
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "PASSWORD")
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(name = "USER_TYPE")
	private UserRole type;
	@Column(name = "EMAIL")
	private String email;
	@Enumerated(EnumType.STRING)
	@Column(name = "SIGN_IN_PROVIDER")
	private SocialProvider signInProvider;

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getType() {
		return type;
	}

	public void setType(UserRole type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SocialProvider getSignInProvider() {
		return signInProvider;
	}

	public void setSignInProvider(SocialProvider signInProvider) {
		this.signInProvider = signInProvider;
	}

}