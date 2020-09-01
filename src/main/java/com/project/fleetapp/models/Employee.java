package com.project.fleetapp.models;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Employee extends Person {
	
	
	@Builder
	public Employee(Long id, EmployeeType employeetypeid, String photo, String username, JobTitle jobTitleid, Instant hireDate, String firstName, 
			String lastName, String otherName, String title, String initials,
			String aadharNumber, String gender, String maritalStatus, Country countryid, State stateid,
			Instant dateOfBirth, String city, String address, String phone, String mobile, String email) {
		
		super(id, firstName, lastName, otherName, title, initials, aadharNumber, gender, maritalStatus, countryid, stateid,
				dateOfBirth, city, address, phone, mobile, email, photo);
		
		this.employeetypeid = employeetypeid;
		this.photo = photo;
		this.username = username;
		this.jobTitleid = jobTitleid;
		this.hireDate = hireDate;
	}
	
	@ManyToOne(targetEntity = EmployeeType.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "employeetypeid", referencedColumnName = "id")
	private EmployeeType employeetypeid;
	
	private String photo;
	private String username;

	@ManyToOne(targetEntity = JobTitle.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "jobTitleid", referencedColumnName = "id")
	private JobTitle jobTitleid;
	
	private Instant hireDate;

}
