package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehiclestatus")
public class VehicleStatusController {
	
	@GetMapping
	public String getVehicleStatus() {
		return "vehicleStatus";
	}
}
