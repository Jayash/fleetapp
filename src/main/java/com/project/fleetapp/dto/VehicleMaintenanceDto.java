package com.project.fleetapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleMaintenanceDto {
	

	private Long id;
	private Long vehicleid;
	private String startDate;
	private String endDate;
	private String price;
	private Long supplierid;
	private String remarks;
	private String name;
}
