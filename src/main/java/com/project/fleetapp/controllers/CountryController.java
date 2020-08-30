package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.fleetapp.models.Country;
import com.project.fleetapp.services.CountryService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/countries")
@AllArgsConstructor
public class CountryController {
	
	private final CountryService countryService;
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("countries", countryService.getAll());
		return "country";
	}
	
	@PostMapping("/addNew")
	public String addNew(Country country) {
		countryService.save(country);
		return "redirect:/countries";
	}
	
	@GetMapping("/findById")
	@ResponseBody
	public Country findById(Long id) {
		return countryService.findById(id);
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.PUT})
	public String update(Country country) {
		countryService.save(country);
		return "redirect:/countries";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Long id) {
		countryService.delete(id);
		return "redirect:/countries";
	}
}
