package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employeetypes")
public class EmployeeTypeController {
	
	@GetMapping
	public String getEmployeeTypes() {
		return "employeeType";
	}
}
