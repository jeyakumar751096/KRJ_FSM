package com.fms.springsecurity.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fms.entity.OutReachEventInformation;
import com.fms.springsecurity.login.service.OutReachEventInformationService;

@RestController
@RequestMapping("/")
public class AdminController {
	
	@Autowired
	private  OutReachEventInformationService outReachEventInformationService;
	
	@GetMapping(value="/admin")
	public ModelAndView welcomeadmin() {
		ModelAndView modelView=new ModelAndView();		
		modelView.setViewName("welcomeadmin");
		return modelView;
	}
	
	
}
