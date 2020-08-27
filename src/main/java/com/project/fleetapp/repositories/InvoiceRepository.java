package com.project.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.fleetapp.models.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
