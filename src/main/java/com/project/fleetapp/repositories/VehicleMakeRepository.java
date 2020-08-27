package com.project.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.fleetapp.models.VehicleMake;

public interface VehicleMakeRepository extends JpaRepository<VehicleMake, Long> {

}
