package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.fleetapp.dto.VehicleMaintenanceDto;
import com.project.fleetapp.services.SupplierService;
import com.project.fleetapp.services.VehicleMaintenanceService;
import com.project.fleetapp.services.VehicleService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/vehiclemaintenance")
@AllArgsConstructor
public class VehicleMaintenanceController {
	
	private final VehicleMaintenanceService vehicleMaintenanceService;
	private final SupplierService supplierService;
	private final VehicleService vehicleService;
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("vehiclemaintenances", vehicleMaintenanceService.getAll());
		model.addAttribute("vehicles", vehicleService.getAll());
		model.addAttribute("suppliers", supplierService.getAll());
		
		return "vehicleMaintenance";
	}
	
	@PostMapping("/addNew")
	public String addNew(VehicleMaintenanceDto vehicleMaintenanceDto) {
		vehicleMaintenanceService.save(vehicleMaintenanceDto);
		return "redirect:/vehiclemaintenance";
	}
	
	@GetMapping("/findById")
	@ResponseBody
	public VehicleMaintenanceDto findById(Long id) {
		return vehicleMaintenanceService.findById(id);
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.PUT})
	public String update(VehicleMaintenanceDto vehicleMaintenanceDto) {
		vehicleMaintenanceService.update(vehicleMaintenanceDto);
		return "redirect:/vehiclemaintenance";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Long id) {
		vehicleMaintenanceService.delete(id);
		return "redirect:/vehiclemaintenance";
	}
}
