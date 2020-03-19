package com.fms.springsecurity.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.entity.OutreachEventsSummary;
import com.fms.springsecurity.login.service.OutreachEventsSummaryService;


@RestController
@RequestMapping("/eventsSummary")
public class OutreachEventsSummaryController {
	
	@Autowired
	private  OutreachEventsSummaryService outreachEventsSummaryService;
	
	@GetMapping(value="/loadAllOutReachEventInformation")
	public ResponseEntity <List<OutreachEventsSummary>> loadAllOutReachEventInformation( ) {
		List<OutreachEventsSummary>  outreachEventsSummary = outreachEventsSummaryService.loadAllOutreachEventsSummary();
		return new ResponseEntity<List<OutreachEventsSummary>>(outreachEventsSummary,HttpStatus.OK);
	}

}
