package com.fms.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="PmoDetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PmoDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pmoDetailId")
	private int pmoDetailId;

	@Column(name="EmployeeID")
	private String employeeId;

	@Column(name="EmpEmail")
	private String empEmail;

	@Column(name="FirstName")
	private String firstName;

	@Column(name="LastName")
	private String lastName;

}
