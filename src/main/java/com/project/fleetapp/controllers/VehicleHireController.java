package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehiclehire")
public class VehicleHireController {
	
	@GetMapping
	public String getVehicleHire() {
		return "vehicleHire";
	}
}
