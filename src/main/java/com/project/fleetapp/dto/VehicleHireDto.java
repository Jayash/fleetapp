package com.project.fleetapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleHireDto {
	
	private Long id;
	private Long vehicleid;
	private String dateOut;
	private String timeOut;
	private String dateIn;
	private String timeIn;
	private Long locationid;
	private String price;
	private Long clientid;
	private String remarks;
	private String name;

}
