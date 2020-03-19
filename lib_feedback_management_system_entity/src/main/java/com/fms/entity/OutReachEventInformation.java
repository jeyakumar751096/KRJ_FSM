package com.fms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name = "OutReachEventInformation")
@Data
public class OutReachEventInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OutReachEventInformId")
	private Integer outReachEventInformId;
	
	@Column(name = "EventID")
	private String eventID;
	
	@Column(name = "BaseLocation")
	private String baseLocation;
	
	@Column(name = "BeneficiaryName")
	private String beneficiaryName;
	
	@Column(name = "CouncilName")
	private String councilName;
	
	@Column(name = "EventName")
	private String eventName;
	
	@Column(name = "EventDescription")
	private String eventDescription;
	
	@Column(name = "EventDate")
	@JsonFormat(pattern ="dd-MM-yy")
	private Date eventDate;
	
	@Column(name = "EmployeeID")
	private String employeeID;
	
	@Column(name = "EmployeeName")
	private String employeeName;
	
	@Column(name = "VolunteerHours")
	private Double volunteerHours;
	
	@Column(name = "TravelHours")
	private Double travelHours;
	
	@Column(name = "LivesImpacted")
	private Double livesImpacted;
	
	@Column(name = "BusinessUnit")
	private String businessUnit;
	
	@Column(name = "Status")
	private String status;
	
	@Column(name = "IIEPCategory")
	private String iiepCategory;

	
}
