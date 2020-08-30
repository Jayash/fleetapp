package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jobtitle")
public class JobTitleController {
	
	@GetMapping
	public String getJobTitle() {
		return "jobTitle";
	}
}
