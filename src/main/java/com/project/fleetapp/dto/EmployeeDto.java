package com.project.fleetapp.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {
	
	private Long id;
	private Long employeetypeid;
	private String username;
	private Long jobTitleid;
	private String hireDate;
	private String firstName;
	private String lastName;
	private String otherName;
	private String title;
	private String initials;
	private String aadharNumber;
	private String gender;
	private String maritalStatus;
	private String dateOfBirth;
	private String city;
	private String address;
	private String phone;
	private String mobile;
	private String email;
	private String photo;
	private Long stateid;
	private Long countryid;
}
