package com.project.fleetapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleDto {
	
	private Long id;
	private String name;
	private Long vehicleTypeid;
	private String vehicleNumber;
	private String registrationDate;
	private String acquisationDate;
	private String description;
	private Long vehicleStatueid;
	private Long employeeid;
	private Long vehicleModelid;
	private Long locationid;
	private String remarks;
	private Long vehicleMakeid;
	private String power;
	private String fuelCapacity;
	private String netWeight;

}
