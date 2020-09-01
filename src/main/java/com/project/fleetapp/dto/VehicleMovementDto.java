package com.project.fleetapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleMovementDto {
	
	private Long id;
	private Long vehicleid;
	private Long locationStartid;
	private String dateStart;
	private Long locationEndid;
	private String dateEnd;
	private String remarks;
	private String name;

}
