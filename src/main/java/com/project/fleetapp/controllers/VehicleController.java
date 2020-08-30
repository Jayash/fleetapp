package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {
	
	@GetMapping
	public String getVehicles() {
		return "vehicle";
	}
}
