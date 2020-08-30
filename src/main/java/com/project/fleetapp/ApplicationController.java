package com.project.fleetapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class ApplicationController {
	
	@GetMapping
	public String goHome() {
		return "index";
	}
	
}
