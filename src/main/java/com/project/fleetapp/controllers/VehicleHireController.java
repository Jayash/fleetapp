package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.fleetapp.dto.VehicleHireDto;
import com.project.fleetapp.services.ClientService;
import com.project.fleetapp.services.LocationService;
import com.project.fleetapp.services.VehicleHireService;
import com.project.fleetapp.services.VehicleService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/vehiclehire")
@AllArgsConstructor
public class VehicleHireController {
	
	private final VehicleHireService vehicleHireService;
	private final LocationService locationService;
	private final VehicleService vehicleService;
	private final ClientService clientService;
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("vehicleHires", vehicleHireService.getAll());
		model.addAttribute("vehicles", vehicleService.getAll());
		model.addAttribute("locations", locationService.getAll());
		model.addAttribute("clients", clientService.getAll());
		
		return "vehicleHire";
	}
	
	@PostMapping("/addNew")
	public String addNew(VehicleHireDto vehicleHireDto) {
		vehicleHireService.save(vehicleHireDto);
		return "redirect:/vehiclehire";
	}
	
	@GetMapping("/findById")
	@ResponseBody
	public VehicleHireDto findById(Long id) {
		return vehicleHireService.findById(id);
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.PUT})
	public String update(VehicleHireDto vehicleHireDto) {
		vehicleHireService.update(vehicleHireDto);
		return "redirect:/vehiclehire";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Long id) {
		vehicleHireService.delete(id);
		return "redirect:/vehiclehire";
	}
}
