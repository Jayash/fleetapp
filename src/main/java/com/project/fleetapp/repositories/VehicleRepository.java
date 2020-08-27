package com.project.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.fleetapp.models.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
