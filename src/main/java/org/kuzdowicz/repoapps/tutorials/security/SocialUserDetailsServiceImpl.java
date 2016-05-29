package org.kuzdowicz.repoapps.tutorials.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SocialUserDetailsServiceImpl implements SocialUserDetailsService {

	private UserDetailsService userDetailsService;

	@Autowired
	public SocialUserDetailsServiceImpl(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {

		UserDetails userDetails = userDetailsService.loadUserByUsername(userId);

		SocialUser socialUser = new SocialUser(userDetails.getUsername(), userDetails.getPassword(),
				userDetails.getAuthorities());

		return socialUser;
	}

}
