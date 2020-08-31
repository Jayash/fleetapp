package com.project.fleetapp.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.fleetapp.exceptions.FleetappException;
import com.project.fleetapp.models.InvoiceStatus;
import com.project.fleetapp.repositories.InvoiceStatusRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InvoiceStatusService {
	
	private final InvoiceStatusRepository invoiceStatusRepository;

	/*
	 * Return All InvoiceStatus
	 */
	@Transactional
	public List<InvoiceStatus> getAll() {
		return invoiceStatusRepository.findAll();
	}

	/*
	 * add a new InvoiceStatus
	 */
	@Transactional
	public void save(InvoiceStatus invoiceStatus) {
		invoiceStatusRepository.save(invoiceStatus);
	}

	/*
	 * find InvoiceStatus by id
	 */
	@Transactional
	public InvoiceStatus findById(Long id) {
		InvoiceStatus invoiceStatus = invoiceStatusRepository.findById(id)
				.orElseThrow(() -> new FleetappException("invoiceStatus not found"));

		return invoiceStatus;
	}

	/*
	 * update InvoiceStatus by id
	 */
	@Transactional
	public void update(InvoiceStatus invoiceStatus) {

		invoiceStatusRepository.save(invoiceStatus);
	}

	/*
	 * delete InvoiceStatus by id
	 */
	@Transactional
	public void delete(Long id) {
		invoiceStatusRepository.deleteById(id);
	}
}
