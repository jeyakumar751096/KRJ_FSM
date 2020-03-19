package com.fms.springsecurity.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.entity.PmoDetails;
import com.fms.springsecurity.login.exception.GlobalExceptionHandler;
import com.fms.springsecurity.login.service.RoleDetailService;

import lombok.experimental.PackagePrivate;


@RestController
@RequestMapping("/roles")
public class RoleDetailController {
	
	@Autowired
	private RoleDetailService  roleDetailService;
	
	@PostMapping("/savePmo")
	public ResponseEntity<PmoDetails> saveRole(@RequestBody PmoDetails pmoDetail) throws GlobalExceptionHandler {
		PmoDetails saveRole = roleDetailService.savePmoDetails(pmoDetail);
		return new ResponseEntity<PmoDetails>(saveRole,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/deletePmo/{employeeId}")
	public ResponseEntity<String> deleteRole(@PathVariable String employeeId) throws GlobalExceptionHandler {
		String msg = roleDetailService.deleteRole(employeeId);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}

}
