package org.kuzdowicz.repoapps.tutorials.security;

import org.kuzdowicz.repoapps.tutorials.constants.UserTypes;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;

@Service
public class SpringSocialSignInAdapter implements SignInAdapter {

	@Override
	public String signIn(String localUserId, Connection<?> conn, NativeWebRequest req) {
		SecurityContextHolder.getContext()
				.setAuthentication(new UsernamePasswordAuthenticationToken(//
						localUserId, //
						null, //
						AuthorityUtils.createAuthorityList(UserTypes.USER)));
		return null;
	}

}
