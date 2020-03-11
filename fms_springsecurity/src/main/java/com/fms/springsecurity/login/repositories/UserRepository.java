package com.fms.springsecurity.login.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.springsecurity.login.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUserName(String userName);
	

}
