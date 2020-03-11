package com.fms.springsecurity.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.fms.springsecurity.login.entity.LoginUserDetails;
import com.fms.springsecurity.login.entity.User;
import com.fms.springsecurity.login.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserLoginDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
 	
	public UserDetails loadByUserName(String userName) {
		User user = userRepository.findByUserName(userName);
		
		return new LoginUserDetails(user);
	}

}
