package com.fms.springsecurity.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fms.springsecurity.login.entity.LoginUserDetails;
import com.fms.springsecurity.login.entity.User;
import com.fms.springsecurity.login.repositories.UserRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDetailsServiceimpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
 	@Override
	public UserDetails loadUserByUsername(String userName) {
		User user = userRepository.findByUserName(userName);
		if(user ==null) {
			throw new UsernameNotFoundException("User not Found");
		}
		
		return new LoginUserDetails(user);
	}

}
