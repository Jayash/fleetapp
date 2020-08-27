package com.project.fleetapp.models;

import java.time.Instant;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String firstName;
	private String lastName;
	private String otherName;
	private String title;
	private String initials;
	private String aadharNumber;
	private String gender;
	private String maritalStatus;
	
	@ManyToOne(targetEntity = Country.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "countryid", referencedColumnName = "id", insertable = false, updatable = false)
	private Country countryid;
	
	@ManyToOne(targetEntity = State.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "stateid", referencedColumnName = "id", insertable = false, updatable = false)
	private State stateid;
	
	private Instant dateOfBirth;
	private String city;
	private String address;
	private String phone;
	private String mobile;
	private String email;
	private String photo;
}
