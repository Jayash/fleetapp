package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.fleetapp.models.VehicleMake;
import com.project.fleetapp.services.VehicleMakeService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/vehiclemake")
@AllArgsConstructor
public class VehicleMakeController {
	
	private final VehicleMakeService vehicleMakeService;
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("vehicleMakes", vehicleMakeService.getAll());
		return "vehicleMake";
	}
	
	@PostMapping("/addNew")
	public String addNew(VehicleMake vehicleMake) {
		vehicleMakeService.save(vehicleMake);
		return "redirect:/vehiclemake";
	}
	
	@GetMapping("/findById")
	@ResponseBody
	public VehicleMake findById(Long id) {
		return vehicleMakeService.findById(id);
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.PUT})
	public String update(VehicleMake vehicleMake) {
		vehicleMakeService.update(vehicleMake);
		return "redirect:/vehiclemake";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Long id) {
		vehicleMakeService.delete(id);
		return "redirect:/vehiclemake";
	}
}
