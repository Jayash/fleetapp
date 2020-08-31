package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.fleetapp.dto.ClientDto;
import com.project.fleetapp.services.ClientService;
import com.project.fleetapp.services.CountryService;
import com.project.fleetapp.services.StateService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {
	
	
	private final ClientService clientService;
	private final CountryService countryService;
	private final StateService stateService;
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("clients", clientService.getAll());
		model.addAttribute("countries", countryService.getAll());
		model.addAttribute("states", stateService.getAll());
		return "client";
	}
	
	@PostMapping("/addNew")
	public String addNew(ClientDto clientDto) {
		clientService.save(clientDto);
		return "redirect:/clients";
	}
	
	@GetMapping("/findById")
	@ResponseBody
	public ClientDto findById(Long id) {
		return clientService.findById(id);
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.PUT})
	public String update(ClientDto clientDto) {
		clientService.update(clientDto);
		return "redirect:/clients";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Long id) {
		clientService.delete(id);
		return "redirect:/clients";
	}
}
