package com.fms.springsecurity.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.entity.OutReachEventInformation;
import com.fms.springsecurity.login.service.OutReachEventInformationService;

@RestController
@RequestMapping("/eventInformation")
public class OutReachEventInformationController {
	
	@Autowired
	private  OutReachEventInformationService outReachEventInformationService;
	
	@GetMapping(value="/loadAllOutReachEventInformation")
	public ResponseEntity <List<OutReachEventInformation>> loadAllOutReachEventInformation( ) {
		List<OutReachEventInformation>  outReachEventInformation = outReachEventInformationService.loadAllOutReachEventInformation();
		return new ResponseEntity<List<OutReachEventInformation>>(outReachEventInformation,HttpStatus.OK);
	}
	
	
	@GetMapping(value="/loadToltalLivesImpact")
	public ResponseEntity<Integer> toltalLivesImpact() {
		Integer countLives= outReachEventInformationService.toltalLivesImpact();
		return new ResponseEntity<Integer>(countLives,HttpStatus.OK);
	}

}
