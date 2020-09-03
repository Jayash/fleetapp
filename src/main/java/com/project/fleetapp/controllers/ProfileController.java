package com.project.fleetapp.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.fleetapp.services.EmployeeService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/profile")
@AllArgsConstructor
public class ProfileController {
	
	private final EmployeeService employeeService;
	
	@GetMapping
	public String profile(Model model, Principal principal) {
		
		String username = principal.getName();
		
		model.addAttribute("employee", employeeService.findByUsername(username));
		return "profile";
	}
}
