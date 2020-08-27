package com.project.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.fleetapp.models.VehicleMovement;

public interface VehicleMovementRepository extends JpaRepository<VehicleMovement, Long> {

}
