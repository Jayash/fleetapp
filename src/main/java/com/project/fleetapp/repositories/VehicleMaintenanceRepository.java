package com.project.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.fleetapp.models.VehicleMaintenance;

public interface VehicleMaintenanceRepository extends JpaRepository<VehicleMaintenance, Long> {

}
