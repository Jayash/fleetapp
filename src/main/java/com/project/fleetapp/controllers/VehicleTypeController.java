package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehicletype")
public class VehicleTypeController {
	
	@GetMapping
	public String getVehicleType() {
		return "vehicleType";
	}
}
