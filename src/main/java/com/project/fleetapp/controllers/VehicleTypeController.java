package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.fleetapp.models.VehicleType;
import com.project.fleetapp.services.VehicleTypeService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/vehicletype")
@AllArgsConstructor
public class VehicleTypeController {
	
	private final VehicleTypeService vehicleTypeService;
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("vehicleTypes", vehicleTypeService.getAll());
		return "vehicleType";
	}
	
	@PostMapping("/addNew")
	public String addNew(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicletype";
	}
	
	@GetMapping("/findById")
	@ResponseBody
	public VehicleType findById(Long id) {
		return vehicleTypeService.findById(id);
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.PUT})
	public String update(VehicleType vehicleType) {
		vehicleTypeService.update(vehicleType);
		return "redirect:/vehicletype";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Long id) {
		vehicleTypeService.delete(id);
		return "redirect:/vehicletype";
	}
}
