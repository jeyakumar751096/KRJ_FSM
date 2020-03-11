package com.fms.springsecurity.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fms.springsecurity.login.service.UserLoginDetailsService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfiguration {
	
	@Bean
	public UserDetailsService userDetailService() {
		return new UserDetailsService();
	}
	
	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authentiProvider = new DaoAuthenticationProvider();
	//	org.springframework.security.core.userdetails.UserDetailsService userDetailService;
		authentiProvider.setUserDetailsService(userDetailService());
		authentiProvider.setPasswordEncoder(bcryptPasswordEncoder());
		return authentiProvider;
	}

}
