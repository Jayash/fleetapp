package com.project.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.fleetapp.models.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
