package com.project.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.fleetapp.models.VehicleStatus;

public interface VehicleStatusRepository extends JpaRepository<VehicleStatus, Long> {

}
