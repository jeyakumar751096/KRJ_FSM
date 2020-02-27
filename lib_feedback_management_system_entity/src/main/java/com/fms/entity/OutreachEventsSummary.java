package com.fms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="OutreachEventsSummary")
public class OutreachEventsSummary {
	@Id
	@Column(name = "OutreachEventsSummaryId")
	private Integer outreachEventsSummaryId;

	@Column(name = "EventID")
	private String eventID;	

	@Column(name = "Months")
	private String months;	

	@Column(name = "BaseLocation")
	private String baseLocation;	

	@Column(name = "BeneficiaryName")
	private String beneficiaryName;	

	@Column(name = "VenueAddress")
	private String venueAddress;	

	@Column(name = "CouncilName")
	private String councilName;	

	@Column(name = "Project")
	private String project;	

	@Column(name = "Category")
	private String category;	
	
	@Column(name = "EventName")
	private String eventName;	

	@Column(name = "EventDescription")
	private String eventDescription;
	
	@Column(name = "EventDate")
	private Date eventDate;	
	
	@Column(name = "Totalnoofvolunteers")
	private Double totalNoOfVolunteers;	

	@Column(name = "TotalVolunteerHours")
	private Double totalVolunteerHours;	

	@Column(name = "TotalTravelHours")
	private Double totalTravelHours;	

	@Column(name = "OverallVolunteeringHours")
	private Double overallVolunteeringHours;	

	@Column(name = "LivesImpacted")
	private Double livesImpacted;	

	@Column(name = "ActivityType")
	private Double activityType;	

	@Column(name = "summary_Status")
	private String status;	

	@Column(name = "POCID")
	private String pocID;	

	@Column(name = "POCName")
	private String pocName;	

	@Column(name = "POCContactNumber")
	private String pocContactNumber;
	
	

}
