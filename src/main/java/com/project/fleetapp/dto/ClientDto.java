package com.project.fleetapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDto {
	
	private Long id;
	private String name;
	private String address;
	private String city;
	private String phone;
	private String mobile;
	private String website;
	private String email;
	private String details;
	private Long countryid;
	private Long stateid;
}
