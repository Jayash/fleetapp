package com.project.fleetapp.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.fleetapp.exceptions.FleetappException;
import com.project.fleetapp.models.VehicleType;
import com.project.fleetapp.repositories.VehicleTypeRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class VehicleTypeService {
	
	private final VehicleTypeRepository vehicleTypeRepository;

	/*
	 * Return All VehicleType
	 */
	@Transactional
	public List<VehicleType> getAll() {
		return vehicleTypeRepository.findAll();
	}

	/*
	 * add a new VehicleType
	 */
	@Transactional
	public void save(VehicleType vehicleType) {
		vehicleTypeRepository.save(vehicleType);
	}

	/*
	 * find VehicleType by id
	 */
	@Transactional
	public VehicleType findById(Long id) {
		VehicleType vehicleType = vehicleTypeRepository.findById(id)
				.orElseThrow(() -> new FleetappException("vehicleType not found"));

		return vehicleType;
	}

	/*
	 * update VehicleType by id
	 */
	@Transactional
	public void update(VehicleType vehicleType) {

		vehicleTypeRepository.save(vehicleType);
	}

	/*
	 * delete VehicleType by id
	 */
	@Transactional
	public void delete(Long id) {
		vehicleTypeRepository.deleteById(id);
	}
}
