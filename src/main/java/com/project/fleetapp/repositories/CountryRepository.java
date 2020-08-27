package com.project.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.fleetapp.models.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
