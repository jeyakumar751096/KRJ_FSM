package com.fms.springsecurity.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fms.springsecurity.login.service.impl.UserLoginDetailsServiceimpl;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
		
	@Bean
	public UserLoginDetailsServiceimpl userLoginDetailsService() {
		return new UserLoginDetailsServiceimpl();
	}
	
	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authentiProvider = new DaoAuthenticationProvider();
	//	org.springframework.security.core.userdetails.UserDetailsService userDetailService;
		authentiProvider.setUserDetailsService(userLoginDetailsService());
		authentiProvider.setPasswordEncoder(bcryptPasswordEncoder());
		return authentiProvider;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider());
	}
	
	/*http
    .authorizeRequests().antMatchers("/wallPage").hasAnyRole("ADMIN", "USER")
    .and()
    .authorizeRequests().antMatchers("/login", "/resource/**").permitAll()
    .and()
.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").permitAll()
    .loginProcessingUrl("/doLogin")
    .successForwardUrl("/postLogin")
    .failureUrl("/loginFailed")
    .and()
    .logout().logoutUrl("/doLogout").logoutSuccessUrl("/logout").permitAll()
    .and()
    .csrf().disable();*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/welcome").hasAnyRole("ADMIN","PMO","POC")
		
		.antMatchers("/login", "/resource/**").permitAll()
		.and()
		.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").permitAll()
		.loginProcessingUrl("/doLogin")
		.successForwardUrl("/postLogin")
		.failureForwardUrl("/loginFailed")
		.and()
		.logout().logoutUrl("/doLogout").logoutSuccessUrl("/logout").permitAll()
        .and()
		.csrf().disable();
		
	}
}
