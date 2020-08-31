package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.fleetapp.models.Contact;
import com.project.fleetapp.services.ContactService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/contacts")
@AllArgsConstructor
public class ContactController {
	
	private final ContactService contactService;
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("contacts", contactService.getAll());
		return "contact";
	}
	
	@PostMapping("/addNew")
	public String addNew(Contact contact) {
		contactService.save(contact);
		return "redirect:/contacts";
	}
	
	@GetMapping("/findById")
	@ResponseBody
	public Contact findById(Long id) {
		return contactService.findById(id);
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.PUT})
	public String update(Contact contact) {
		contactService.update(contact);
		return "redirect:/contacts";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Long id) {
		contactService.delete(id);
		return "redirect:/contacts";
	}
}
