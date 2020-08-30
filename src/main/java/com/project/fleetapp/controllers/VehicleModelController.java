package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehiclemodel")
public class VehicleModelController {
	
	@GetMapping
	public String getVehicleModel() {
		return "vehicleModel";
	}
}
