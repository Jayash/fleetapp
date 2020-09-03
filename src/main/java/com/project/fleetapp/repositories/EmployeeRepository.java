package com.project.fleetapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.fleetapp.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public Optional<Employee> findByUsername(String username);

}
