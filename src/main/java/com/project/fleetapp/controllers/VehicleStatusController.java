package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.fleetapp.models.VehicleStatus;
import com.project.fleetapp.services.VehicleStatusService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/vehiclestatus")
@AllArgsConstructor
public class VehicleStatusController {
	
	private final VehicleStatusService vehicleStatusService;
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("vehicleStatuses", vehicleStatusService.getAll());
		return "vehicleStatus";
	}
	
	@PostMapping("/addNew")
	public String addNew(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehiclestatus";
	}
	
	@GetMapping("/findById")
	@ResponseBody
	public VehicleStatus findById(Long id) {
		return vehicleStatusService.findById(id);
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.PUT})
	public String update(VehicleStatus vehicleStatus) {
		vehicleStatusService.update(vehicleStatus);
		return "redirect:/vehiclestatus";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Long id) {
		vehicleStatusService.delete(id);
		return "redirect:/vehiclestatus";
	}
}
