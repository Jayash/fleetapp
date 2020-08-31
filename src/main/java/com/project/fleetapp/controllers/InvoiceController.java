package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.fleetapp.dto.InvoiceDto;
import com.project.fleetapp.services.ClientService;
import com.project.fleetapp.services.InvoiceService;
import com.project.fleetapp.services.InvoiceStatusService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/invoices")
@AllArgsConstructor
public class InvoiceController {
	
	
	private final InvoiceService invoiceService;
	private final ClientService clientService;
	private final InvoiceStatusService invoiceStatusService;
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("invoices", invoiceService.getAll());
		model.addAttribute("clients", clientService.getAll());
		model.addAttribute("invoiceStatuses", invoiceStatusService.getAll());
		return "invoice";
	}
	
	@PostMapping("/addNew")
	public String addNew(InvoiceDto invoiceDto) {
		invoiceService.save(invoiceDto);
		return "redirect:/invoices";
	}
	
	@GetMapping("/findById")
	@ResponseBody
	public InvoiceDto findById(Long id) {
		return invoiceService.findById(id);
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.PUT})
	public String update(InvoiceDto invoiceDto) {
		invoiceService.update(invoiceDto);
		return "redirect:/invoices";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Long id) {
		invoiceService.delete(id);
		return "redirect:/invoices";
	}
}
