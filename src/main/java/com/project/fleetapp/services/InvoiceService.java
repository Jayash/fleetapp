package com.project.fleetapp.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.fleetapp.dto.InvoiceDto;
import com.project.fleetapp.exceptions.FleetappException;
import com.project.fleetapp.models.Client;
import com.project.fleetapp.models.Invoice;
import com.project.fleetapp.models.InvoiceStatus;
import com.project.fleetapp.repositories.ClientRepository;
import com.project.fleetapp.repositories.InvoiceRepository;
import com.project.fleetapp.repositories.InvoiceStatusRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InvoiceService {
	
	private final InvoiceRepository invoiceRepository;
	private final ClientRepository clientRepository;
	private final InvoiceStatusRepository invoiceStatusRepository;
	
	/*
	 * Return All invoice
	 */
	@Transactional
	public List<Invoice> getAll() {
		
		return invoiceRepository.findAll();
		/*return invoiceRepository.findAll().stream()
				.map(this::mapObjectToDto)
				.collect(Collectors.toList());*/
	}
	
	/*
	 * add a new invoice
	 */
	@Transactional
	public void save(InvoiceDto invoiceDto) {
		Client client = clientRepository.findById(invoiceDto.getClientid())
								.orElseThrow(() -> new FleetappException("client not found"));
		
		InvoiceStatus invoiceStatus = invoiceStatusRepository.findById(invoiceDto.getInvoicestatusid())
								.orElseThrow(() -> new FleetappException("invoice status not found"));
		
		Invoice invoice = mapDtoToObject(invoiceDto);
		invoice.setClientid(client);
		invoice.setInvoiceStatusid(invoiceStatus);
		invoiceRepository.save(invoice);
	}
	
	/*
	 * find invoice by id
	 */
	@Transactional
	public InvoiceDto findById(Long id) {
		Invoice invoice = invoiceRepository.findById(id).
				orElseThrow(() -> new FleetappException("invoice not found"));
		
		return mapObjectToDto(invoice);
	}
	
	/*
	 * update invoice by id
	 */
	@Transactional
	public void update(InvoiceDto invoiceDto) {
		LocalDate date = LocalDate.parse(invoiceDto.getInvoiceDate());
		Instant instant = date.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		Invoice invoice = invoiceRepository.findById(invoiceDto.getId()).
				orElseThrow(() -> new FleetappException("invoice not found"));
		
		Client client = clientRepository.findById(invoiceDto.getClientid())
				.orElseThrow(() -> new FleetappException("client not found"));
		
		InvoiceStatus invoiceStatus = invoiceStatusRepository.findById(invoiceDto.getInvoicestatusid())
				.orElseThrow(() -> new FleetappException("invoice status not found"));
		
		invoice.setClientid(client);
		invoice.setInvoiceStatusid(invoiceStatus);
		invoice.setRemarks(invoiceDto.getRemarks());
		invoice.setInvoiceDate(instant);

		invoiceRepository.save(invoice);
	}
	
	public InvoiceDto mapObjectToDto(Invoice invoice) {
		return InvoiceDto.builder()
				.id(invoice.getId())
				.invoiceDate(invoice.getInvoiceDate().toString())
				.clientid(invoice.getClientid().getId())
				.invoicestatusid(invoice.getInvoiceStatusid().getId())
				.remarks(invoice.getRemarks())
				.build();
	}
	
	public Invoice mapDtoToObject(InvoiceDto invoiceDto) {
		LocalDate date = LocalDate.parse(invoiceDto.getInvoiceDate());
		Instant instant = date.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		return Invoice.builder()
				.invoiceDate(instant)
				.remarks(invoiceDto.getRemarks())
				.build();
	}
	
	/*
	 * delete Invoice by id
	 */
	@Transactional
	public void delete(Long id) {
		invoiceRepository.deleteById(id);
	}
}
