package com.fms.springsecurity.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.entity.OutReachEventInformation;
import com.fms.springsecurity.login.repositories.OutReachEventInformationRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OutReachEventInformationService {
	
	private  OutReachEventInformationRepository outReachEventInformationRepository;
	
	public List<OutReachEventInformation> loadAllOutReachEventInformation() {
		return outReachEventInformationRepository.findAll();
		
	}
	
	public Integer toltalLivesImpact() {
		return outReachEventInformationRepository.toltalLivesImpact();
	}
	
	

}
