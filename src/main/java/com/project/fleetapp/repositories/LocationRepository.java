package com.project.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.fleetapp.models.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
