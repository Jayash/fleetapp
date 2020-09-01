package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.fleetapp.dto.EmployeeDto;
import com.project.fleetapp.services.CountryService;
import com.project.fleetapp.services.EmployeeService;
import com.project.fleetapp.services.EmployeeTypeService;
import com.project.fleetapp.services.JobTitleService;
import com.project.fleetapp.services.StateService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {
	
	private final EmployeeService employeeService;
	private final JobTitleService jobTitleService;
	private final EmployeeTypeService employeeTypeService;
	private final StateService stateService;
	private final CountryService countryService;
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("employees", employeeService.getAll());
		model.addAttribute("jobTitles", jobTitleService.getAll());
		model.addAttribute("employeeTypes", employeeTypeService.getAll());
		model.addAttribute("states", stateService.getAll());
		model.addAttribute("countries", countryService.getAll());
		
		return "employee";
	}
	
	@PostMapping("/addNew")
	public String addNew(EmployeeDto employeeDto) {
		employeeService.save(employeeDto);
		return "redirect:/employees";
	}
	
	@GetMapping("/findById")
	@ResponseBody
	public EmployeeDto findById(Long id) {
		return employeeService.findById(id);
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.PUT})
	public String update(EmployeeDto employeeDto) {
		employeeService.update(employeeDto);
		return "redirect:/employees";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Long id) {
		employeeService.delete(id);
		return "redirect:/employees";
	}
}	
