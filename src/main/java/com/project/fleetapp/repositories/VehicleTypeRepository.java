package com.project.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.fleetapp.models.VehicleType;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {

}
