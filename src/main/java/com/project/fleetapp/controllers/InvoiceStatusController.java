package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/invoicestatus")
public class InvoiceStatusController {
	
	@GetMapping
	public String getInvoiceStatus() {
		return "invoiceStatus";
	}
}
