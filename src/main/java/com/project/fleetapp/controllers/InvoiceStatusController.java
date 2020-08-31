package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.fleetapp.models.InvoiceStatus;
import com.project.fleetapp.services.InvoiceStatusService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/invoicestatus")
@AllArgsConstructor
public class InvoiceStatusController {
	
	private final InvoiceStatusService invoiceStatusService;
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("invoiceStatuses", invoiceStatusService.getAll());
		return "invoiceStatus";
	}
	
	@PostMapping("/addNew")
	public String addNew(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoicestatus";
	}
	
	@GetMapping("/findById")
	@ResponseBody
	public InvoiceStatus findById(Long id) {
		return invoiceStatusService.findById(id);
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.PUT})
	public String update(InvoiceStatus invoiceStatus) {
		invoiceStatusService.update(invoiceStatus);
		return "redirect:/invoicestatus";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Long id) {
		invoiceStatusService.delete(id);
		return "redirect:/invoicestatus";
	}
}
