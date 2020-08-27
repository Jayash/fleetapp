package com.project.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.fleetapp.models.VehicleHire;

public interface VehicleHireRepository extends JpaRepository<VehicleHire, Long> {

}
