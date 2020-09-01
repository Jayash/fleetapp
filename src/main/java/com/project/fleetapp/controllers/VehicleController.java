package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.fleetapp.dto.VehicleDto;
import com.project.fleetapp.services.EmployeeService;
import com.project.fleetapp.services.LocationService;
import com.project.fleetapp.services.VehicleMakeService;
import com.project.fleetapp.services.VehicleModelService;
import com.project.fleetapp.services.VehicleService;
import com.project.fleetapp.services.VehicleStatusService;
import com.project.fleetapp.services.VehicleTypeService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/vehicles")
@AllArgsConstructor
public class VehicleController {
	
	private final VehicleService vehicleService;
	private final LocationService locationService;
	private final VehicleStatusService vehicleStatusService;
	private final EmployeeService employeeService;
	private final VehicleModelService vehicleModelService;
	private final VehicleTypeService vehicleTypeService;
	private final VehicleMakeService vehicleMakeService;
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("vehicles", vehicleService.getAll());
		model.addAttribute("vehicleTypes", vehicleTypeService.getAll());
		model.addAttribute("vehicleModels", vehicleModelService.getAll());
		model.addAttribute("vehicleMakes", vehicleMakeService.getAll());
		model.addAttribute("locations", locationService.getAll());
		model.addAttribute("employees", employeeService.getAll());
		model.addAttribute("vehicleStatuses", vehicleStatusService.getAll());
		
		return "vehicle";
	}
	
	@PostMapping("/addNew")
	public String addNew(VehicleDto vehicleDto) {
		vehicleService.save(vehicleDto);
		return "redirect:/vehicles";
	}
	
	@GetMapping("/findById")
	@ResponseBody
	public VehicleDto findById(Long id) {
		return vehicleService.findById(id);
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.PUT})
	public String update(VehicleDto vehicleDto) {
		vehicleService.update(vehicleDto);
		return "redirect:/vehicles";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Long id) {
		vehicleService.delete(id);
		return "redirect:/vehicles";
	}
}
