package com.fms.springsecurity.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class PocController {
	
	@GetMapping(value="/poc")
	public ModelAndView welcomeadmin() {
		ModelAndView modelView=new ModelAndView();		
		modelView.setViewName("welcomepoc");
		return modelView;
	}

}
