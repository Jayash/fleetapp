package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehiclemovement")
public class VehicleMovementController {
	
	@GetMapping
	public String getVehicleMovement() {
		return "vehicleMovement";
	}
}
