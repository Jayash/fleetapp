package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.fleetapp.dto.SupplierDto;
import com.project.fleetapp.services.CountryService;
import com.project.fleetapp.services.StateService;
import com.project.fleetapp.services.SupplierService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/suppliers")
@AllArgsConstructor
public class SupplierController {
	
	private final SupplierService supplierService;
	private final CountryService countryService;
	private final StateService stateService;
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("suppliers", supplierService.getAll());
		model.addAttribute("countries", countryService.getAll());
		model.addAttribute("states", stateService.getAll());
		return "supplier";
	}
	
	@PostMapping("/addNew")
	public String addNew(SupplierDto supplierDto) {
		supplierService.save(supplierDto);
		return "redirect:/suppliers";
	}
	
	@GetMapping("/findById")
	@ResponseBody
	public SupplierDto findById(Long id) {
		return supplierService.findById(id);
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.PUT})
	public String update(SupplierDto supplierDto) {
		supplierService.update(supplierDto);
		return "redirect:/suppliers";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Long id) {
		supplierService.delete(id);
		return "redirect:/suppliers";
	}
}
