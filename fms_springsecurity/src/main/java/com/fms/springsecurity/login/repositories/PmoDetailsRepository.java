package com.fms.springsecurity.login.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fms.entity.PmoDetails;


@Repository
public interface PmoDetailsRepository extends PagingAndSortingRepository<PmoDetails, Integer>{
	
	PmoDetails findByEmpEmail(String EmailId);
	
	PmoDetails findByEmployeeId(String employeeId);
	
}
