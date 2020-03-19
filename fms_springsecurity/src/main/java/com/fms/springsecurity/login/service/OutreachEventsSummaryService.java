package com.fms.springsecurity.login.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fms.entity.OutreachEventsSummary;
import com.fms.springsecurity.login.repositories.OutreachEventsSummaryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OutreachEventsSummaryService {
	
	private  OutreachEventsSummaryRepository outreachEventsSummaryRepository;
	
	public List<OutreachEventsSummary> loadAllOutreachEventsSummary() {
		return  outreachEventsSummaryRepository.findAll();
	}

}
