package com.project.fleetapp.dto;

import com.project.fleetapp.models.Country;
import com.project.fleetapp.models.State;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationDto {
	
	private Long id;
	private String description;
	private String details;
	private Long countryid;
	private Long stateid;
	private String city;
	private String address;
}
