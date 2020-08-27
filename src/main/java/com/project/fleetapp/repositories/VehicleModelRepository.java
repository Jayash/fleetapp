package com.project.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.fleetapp.models.VehicleModel;

public interface VehicleModelRepository extends JpaRepository<VehicleModel, Long> {

}
