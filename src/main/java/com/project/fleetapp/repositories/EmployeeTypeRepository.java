package com.project.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.fleetapp.models.EmployeeType;

public interface EmployeeTypeRepository extends JpaRepository<EmployeeType, Long> {

}
