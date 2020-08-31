package com.project.fleetapp.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.fleetapp.exceptions.FleetappException;
import com.project.fleetapp.models.EmployeeType;
import com.project.fleetapp.repositories.EmployeeTypeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeTypeService {
	
	private final EmployeeTypeRepository employeeTypeRepository;

	/*
	 * Return All EmployeeType
	 */
	@Transactional
	public List<EmployeeType> getAll() {
		return employeeTypeRepository.findAll();
	}

	/*
	 * add a new EmployeeType
	 */
	@Transactional
	public void save(EmployeeType employeeType) {
		employeeTypeRepository.save(employeeType);
	}

	/*
	 * find EmployeeType by id
	 */
	@Transactional
	public EmployeeType findById(Long id) {
		EmployeeType employeeType = employeeTypeRepository.findById(id)
				.orElseThrow(() -> new FleetappException("employeeType not found"));

		return employeeType;
	}

	/*
	 * update EmployeeType by id
	 */
	@Transactional
	public void update(EmployeeType employeeType) {

		employeeTypeRepository.save(employeeType);
	}

	/*
	 * delete EmployeeType by id
	 */
	@Transactional
	public void delete(Long id) {
		employeeTypeRepository.deleteById(id);
	}
}
