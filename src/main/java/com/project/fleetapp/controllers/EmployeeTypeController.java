package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.fleetapp.models.EmployeeType;
import com.project.fleetapp.services.EmployeeTypeService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/employeetypes")
@AllArgsConstructor
public class EmployeeTypeController {
	
	private final EmployeeTypeService employeeTypeService;
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("employeeTypes", employeeTypeService.getAll());
		return "employeeType";
	}
	
	@PostMapping("/addNew")
	public String addNew(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return "redirect:/employeetypes";
	}
	
	@GetMapping("/findById")
	@ResponseBody
	public EmployeeType findById(Long id) {
		return employeeTypeService.findById(id);
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.PUT})
	public String update(EmployeeType employeeType) {
		employeeTypeService.update(employeeType);
		return "redirect:/employeetypes";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Long id) {
		employeeTypeService.delete(id);
		return "redirect:/employeetypes";
	}
}
