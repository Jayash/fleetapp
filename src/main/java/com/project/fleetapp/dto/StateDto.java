package com.project.fleetapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StateDto {
	
	private Long id;
	private String name;
	private String capital;
	private String code;
	private Long countryid;
	private String details;
}
