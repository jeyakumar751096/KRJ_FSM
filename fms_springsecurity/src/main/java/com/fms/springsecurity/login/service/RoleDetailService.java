package com.fms.springsecurity.login.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fms.entity.PmoDetails;
import com.fms.springsecurity.login.exception.GlobalExceptionHandler;
import com.fms.springsecurity.login.repositories.PmoDetailsRepository;

import lombok.extern.slf4j.Slf4j;


@Service
public class RoleDetailService {
	
	private static Logger logg= LoggerFactory.getLogger(RoleDetailService.class);
	
	@Autowired
	private PmoDetailsRepository pmoDetailsRepository;
	
	
	@Transactional(propagation = Propagation.REQUIRED) 
	public PmoDetails savePmoDetails(PmoDetails pmoDetail) throws GlobalExceptionHandler{
		PmoDetails pmoDet = null;
		try {
			
			pmoDet =  pmoDetailsRepository.save(pmoDetail);
			logg.info("success full install");
			
		} catch (Exception e) {
			throw new GlobalExceptionHandler(e.getMessage());
		}
		return pmoDet;
		
	}
	
	public String deleteRole(String employeeId ) throws GlobalExceptionHandler {
		PmoDetails PmoDetail = findBYEmployeeId(employeeId);
		if(null ==PmoDetail ) {
			throw new GlobalExceptionHandler("Regord not found in pom tables");
		}
		pmoDetailsRepository.delete(PmoDetail);
		return "Pmo deleted by Admin";
		
	}
	
	
	public PmoDetails findBYEmployeeId(String employeeId ) {
		PmoDetails pomDet = pmoDetailsRepository.findByEmployeeId(employeeId);
		return pomDet;
	}

}
