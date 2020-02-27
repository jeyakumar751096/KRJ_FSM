package com.fms.entity;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name ="VolunteerEnrollmentDetailsUnregistered_notattend")
public class VolunteerEnrollmentDetailsUnregisteredNotAttend {
	
	@Id
	@Column(name = "VolunteerEnrollmentId")
	private Integer volunteerEnrollmentId;

	@Column(name = "EventID")
	private String eventID;	

	@Column(name = "EventName")
	private String eventName;	

	@Column(name = "BeneficiaryName")
	private String beneficiaryName;	

	@Column(name = "BaseLocation")
	private String baseLocation;	

	@Column(name = "EventDate")
	private OffsetDateTime eventDate;	

	@Column(name = "EmployeeID")
	private String employeeID;

	@Column(name = "EnrollmentDetailNotAttend")
	private Boolean enrollmentDetailNotAttend;

	@Column(name = "EnrollmentDetailsUnregistered")
	private Boolean enrollmentDetailsUnregistered;
	
	

}
