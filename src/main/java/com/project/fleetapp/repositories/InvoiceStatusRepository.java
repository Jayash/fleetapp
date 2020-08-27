package com.project.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.fleetapp.models.InvoiceStatus;

public interface InvoiceStatusRepository extends JpaRepository<InvoiceStatus, Long> {

}
