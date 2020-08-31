package com.project.fleetapp.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.fleetapp.exceptions.FleetappException;
import com.project.fleetapp.models.VehicleModel;
import com.project.fleetapp.repositories.VehicleModelRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VehicleModelService {

	private final VehicleModelRepository vehicleModelRepository;

	/*
	 * Return All VehicleModel
	 */
	@Transactional
	public List<VehicleModel> getAll() {
		return vehicleModelRepository.findAll();
	}

	/*
	 * add a new VehicleModel
	 */
	@Transactional
	public void save(VehicleModel vehicleModel) {
		vehicleModelRepository.save(vehicleModel);
	}

	/*
	 * find VehicleModel by id
	 */
	@Transactional
	public VehicleModel findById(Long id) {
		VehicleModel vehicleModel = vehicleModelRepository.findById(id)
				.orElseThrow(() -> new FleetappException("vehicleModel not found"));

		return vehicleModel;
	}

	/*
	 * update VehicleModel by id
	 */
	@Transactional
	public void update(VehicleModel vehicleModel) {

		vehicleModelRepository.save(vehicleModel);
	}

	/*
	 * delete VehicleModel by id
	 */
	@Transactional
	public void delete(Long id) {
		vehicleModelRepository.deleteById(id);
	}
}
