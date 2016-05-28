package org.kuzdowicz.repoapps.tutorials.security;

import org.kuzdowicz.repoapps.tutorials.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateUserAfterRegistrationService {

	private UserDetailsService userDetailsService;

	@Autowired
	public AuthenticateUserAfterRegistrationService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	public void authenticateUser(AppUser user) {

		UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());

		Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),
				userDetails.getAuthorities());

		SecurityContextHolder.getContext().setAuthentication(auth);
	}

}
