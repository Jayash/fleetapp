package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.fleetapp.dto.StateDto;
import com.project.fleetapp.services.CountryService;
import com.project.fleetapp.services.StateService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/states")
@AllArgsConstructor
public class StateController {
	
	private final StateService stateService;
	
	private final CountryService countryService;
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("states", stateService.getAll());
		model.addAttribute("countries", countryService.getAll());
		return "state";
	}
	
	@PostMapping("/addNew")
	public String addNew(StateDto stateDto) {
		stateService.save(stateDto);
		return "redirect:/states";
	}
	
	@GetMapping("/findById")
	@ResponseBody
	public StateDto findById(Long id) {
		return stateService.findById(id);
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.PUT})
	public String update(StateDto stateDto) {
		stateService.update(stateDto);
		return "redirect:/states";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Long id) {
		stateService.delete(id);
		return "redirect:/states";
	}
}
