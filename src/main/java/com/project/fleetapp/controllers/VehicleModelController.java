package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.fleetapp.models.VehicleModel;
import com.project.fleetapp.services.VehicleModelService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/vehiclemodel")
@AllArgsConstructor
public class VehicleModelController {
	
	private final VehicleModelService vehicleModelService;
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("vehicleModels", vehicleModelService.getAll());
		return "vehicleModel";
	}
	
	@PostMapping("/addNew")
	public String addNew(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);
		return "redirect:/vehiclemodel";
	}
	
	@GetMapping("/findById")
	@ResponseBody
	public VehicleModel findById(Long id) {
		return vehicleModelService.findById(id);
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.PUT})
	public String update(VehicleModel vehicleModel) {
		vehicleModelService.update(vehicleModel);
		return "redirect:/vehiclemodel";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Long id) {
		vehicleModelService.delete(id);
		return "redirect:/vehiclemodel";
	}
}
