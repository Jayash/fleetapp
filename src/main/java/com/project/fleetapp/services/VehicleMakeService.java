package com.project.fleetapp.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.fleetapp.exceptions.FleetappException;
import com.project.fleetapp.models.VehicleMake;
import com.project.fleetapp.repositories.VehicleMakeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VehicleMakeService {
	
	private final VehicleMakeRepository vehicleMakeRepository;
	
	/*
	 * Return All VehicleMake
	 */
	@Transactional
	public List<VehicleMake> getAll() {
		return vehicleMakeRepository.findAll();
	}
	
	/*
	 * add a new VehicleMake
	 */
	@Transactional
	public void save(VehicleMake vehicleMake) {
		vehicleMakeRepository.save(vehicleMake);
	}
	
	/*
	 * find VehicleMake by id
	 */
	@Transactional
	public VehicleMake findById(Long id) {
		VehicleMake vehicleMake = vehicleMakeRepository.findById(id).
				orElseThrow(() -> new FleetappException("vehicleMake not found"));
		
		return vehicleMake;
	}
	
	/*
	 * update VehicleMake by id
	 */
	@Transactional
	public void update(VehicleMake vehicleMake) {
		
		vehicleMakeRepository.save(vehicleMake);
	}
	
	/*
	 * delete VehicleMake by id
	 */
	@Transactional
	public void delete(Long id) {
		vehicleMakeRepository.deleteById(id);
	}
}
