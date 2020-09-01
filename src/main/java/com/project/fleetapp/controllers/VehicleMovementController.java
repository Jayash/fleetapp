package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.fleetapp.dto.VehicleMovementDto;
import com.project.fleetapp.services.LocationService;
import com.project.fleetapp.services.VehicleMovementService;
import com.project.fleetapp.services.VehicleService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/vehiclemovement")
@AllArgsConstructor
public class VehicleMovementController {
	
	
	private final VehicleMovementService vehicleMovementService;
	private final LocationService locationService;
	private final VehicleService vehicleService;
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("vehiclemovements", vehicleMovementService.getAll());
		model.addAttribute("vehicles", vehicleService.getAll());
		model.addAttribute("locations", locationService.getAll());
		
		return "vehicleMovement";
	}
	
	@PostMapping("/addNew")
	public String addNew(VehicleMovementDto vehicleMovementDto) {
		vehicleMovementService.save(vehicleMovementDto);
		return "redirect:/vehiclemovement";
	}
	
	@GetMapping("/findById")
	@ResponseBody
	public VehicleMovementDto findById(Long id) {
		return vehicleMovementService.findById(id);
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.PUT})
	public String update(VehicleMovementDto vehicleMovementDto) {
		vehicleMovementService.update(vehicleMovementDto);
		return "redirect:/vehiclemovement";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Long id) {
		vehicleMovementService.delete(id);
		return "redirect:/vehiclemovement";
	}
}
