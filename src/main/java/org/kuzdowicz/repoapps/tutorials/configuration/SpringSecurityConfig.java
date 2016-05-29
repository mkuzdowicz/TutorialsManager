package org.kuzdowicz.repoapps.tutorials.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SpringSocialConfigurer;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity webSecurity) throws Exception {

		webSecurity.ignoring().antMatchers("/resources/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http//
				.formLogin()//
				.loginPage("/login")//
				.defaultSuccessUrl("/user/tutorials-to-do")//
				.and()//
				.authorizeRequests()//
				.antMatchers("/user/**")//
				.hasAnyRole("USER", "ADMIN")//
				.antMatchers("/admin/**").hasRole("ADMIN")//
				.anyRequest().permitAll()//
				.and().//
				apply(springSocialConfigurer());
	}

	private SpringSocialConfigurer springSocialConfigurer() {
		SpringSocialConfigurer scf = new SpringSocialConfigurer();
		scf.signupUrl("/create-account");
		return scf;
	}

}
