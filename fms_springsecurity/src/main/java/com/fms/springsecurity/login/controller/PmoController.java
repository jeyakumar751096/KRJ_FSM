package com.fms.springsecurity.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class PmoController {
	
	@GetMapping(value="/pmo")
	public ModelAndView welcomeadmin() {
		ModelAndView modelView=new ModelAndView();		
		modelView.setViewName("welcomepmo");
		return modelView;
	}
}
