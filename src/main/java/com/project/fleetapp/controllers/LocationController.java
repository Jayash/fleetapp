package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.fleetapp.dto.LocationDto;
import com.project.fleetapp.services.CountryService;
import com.project.fleetapp.services.LocationService;
import com.project.fleetapp.services.StateService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/locations")
@AllArgsConstructor
public class LocationController {
	
	private final LocationService locationService;
	private final CountryService countryService;
	private final StateService stateService;
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("locations", locationService.getAll());
		model.addAttribute("countries", countryService.getAll());
		model.addAttribute("states", stateService.getAll());
		return "location";
	}
	
	@PostMapping("/addNew")
	public String addNew(LocationDto locationDto) {
		locationService.save(locationDto);
		return "redirect:/locations";
	}
	
	@GetMapping("/findById")
	@ResponseBody
	public LocationDto findById(Long id) {
		return locationService.findById(id);
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.PUT})
	public String update(LocationDto locationDto) {
		locationService.update(locationDto);
		return "redirect:/locations";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Long id) {
		locationService.delete(id);
		return "redirect:/locations";
	}
}
