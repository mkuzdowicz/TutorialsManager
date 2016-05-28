package org.kuzdowicz.repoapps.tutorials.security;

import java.util.Collection;

import org.kuzdowicz.repoapps.tutorials.models.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;

	private AppUser appUser;

	public UserDetailsImpl(AppUser appUser) {
		this.appUser = appUser;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return AuthorityUtils.createAuthorityList(appUser.getType());
	}

	@Override
	public String getPassword() {

		return appUser.getPassword();
	}

	@Override
	public String getUsername() {

		return appUser.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}
