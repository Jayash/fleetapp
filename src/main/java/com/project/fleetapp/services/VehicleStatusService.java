package com.project.fleetapp.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.fleetapp.exceptions.FleetappException;
import com.project.fleetapp.models.VehicleStatus;
import com.project.fleetapp.repositories.VehicleStatusRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VehicleStatusService {
	
	private final VehicleStatusRepository vehicleStatusRepository;

	/*
	 * Return All VehicleStatus
	 */
	@Transactional
	public List<VehicleStatus> getAll() {
		return vehicleStatusRepository.findAll();
	}

	/*
	 * add a new VehicleStatus
	 */
	@Transactional
	public void save(VehicleStatus vehicleStatus) {
		vehicleStatusRepository.save(vehicleStatus);
	}

	/*
	 * find VehicleStatus by id
	 */
	@Transactional
	public VehicleStatus findById(Long id) {
		VehicleStatus vehicleStatus = vehicleStatusRepository.findById(id)
				.orElseThrow(() -> new FleetappException("vehicleStatus not found"));

		return vehicleStatus;
	}

	/*
	 * update VehicleStatus by id
	 */
	@Transactional
	public void update(VehicleStatus vehicleStatus) {

		vehicleStatusRepository.save(vehicleStatus);
	}

	/*
	 * delete VehicleStatus by id
	 */
	@Transactional
	public void delete(Long id) {
		vehicleStatusRepository.deleteById(id);
	}
}
