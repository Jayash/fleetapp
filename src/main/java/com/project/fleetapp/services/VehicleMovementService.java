package com.project.fleetapp.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.fleetapp.dto.VehicleMovementDto;
import com.project.fleetapp.exceptions.FleetappException;
import com.project.fleetapp.models.Location;
import com.project.fleetapp.models.VehicleMovement;
import com.project.fleetapp.repositories.LocationRepository;
import com.project.fleetapp.repositories.VehicleMovementRepository;
import com.project.fleetapp.repositories.VehicleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VehicleMovementService {
	
	private final VehicleMovementRepository vehicleMovementRepository;
	private final VehicleRepository vehicleRepository;
	private final LocationRepository locationRepository;
	
	/*
	 * Return All vehicleMovement
	 */
	@Transactional
	public List<VehicleMovementDto> getAll() {
		
		return vehicleMovementRepository.findAll()
				.stream()
				.map(this::mapObjectToDto)
				.collect(Collectors.toList());
		//return vehicleMovementRepository.findAll();
	}
	
	/*
	 * add a new vehicleMovement
	 */
	@Transactional
	public void save(VehicleMovementDto vehicleMovementDto) {
		/*Vehicle vehicle = vehicleRepository.findById(vehicleMovementDto.getVehicleid())
								.orElseThrow(() -> new FleetappException("vehicle not found"));*/
		
		Location startLocation = locationRepository.findById(vehicleMovementDto.getLocationStartid())
								.orElseThrow(() -> new FleetappException("location not found"));
		Location endLocation = locationRepository.findById(vehicleMovementDto.getLocationEndid())
								.orElseThrow(() -> new FleetappException("location not found"));
		
		VehicleMovement vehicleMovement = mapDtoToObject(vehicleMovementDto);
		//vehicleMovement.setVehicleid(vehicle);
		vehicleMovement.setLocationStartid(startLocation);
		vehicleMovement.setLocationEndid(endLocation);
		vehicleMovementRepository.save(vehicleMovement);
	}
	
	/*
	 * find vehicleMovement by id
	 */
	@Transactional
	public VehicleMovementDto findById(Long id) {
		VehicleMovement vehicleMovement = vehicleMovementRepository.findById(id).
				orElseThrow(() -> new FleetappException("vehicleMovement not found"));
		
		return mapObjectToDto(vehicleMovement);
	}
	
	/*
	 * update vehicleMovement by id
	 */
	@Transactional
	public void update(VehicleMovementDto vehicleMovementDto) {
		LocalDate start = LocalDate.parse(vehicleMovementDto.getDateStart());
		Instant instantStart = start.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		LocalDate end = LocalDate.parse(vehicleMovementDto.getDateEnd());
		Instant instantEnd = end.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		VehicleMovement vehicleMovement = vehicleMovementRepository.findById(vehicleMovementDto.getId()).
				orElseThrow(() -> new FleetappException("vehicleMovement not found"));
		
		/*Vehicle vehicle = vehicleRepository.findById(vehicleMovementDto.getVehicleid())
				.orElseThrow(() -> new FleetappException("vehicle not found"));*/
		
		Location startLocation = locationRepository.findById(vehicleMovementDto.getLocationStartid())
				.orElseThrow(() -> new FleetappException("location not found"));
		Location endLocation = locationRepository.findById(vehicleMovementDto.getLocationEndid())
				.orElseThrow(() -> new FleetappException("location not found"));
		
		//vehicleMovement.setVehicleid(vehicle);
		vehicleMovement.setLocationStartid(startLocation);
		vehicleMovement.setLocationEndid(endLocation);
		vehicleMovement.setDateStart(instantStart);
		vehicleMovement.setDateEnd(instantEnd);
		vehicleMovement.setRemarks(vehicleMovementDto.getRemarks());

		vehicleMovementRepository.save(vehicleMovement);
	}
	
	public VehicleMovementDto mapObjectToDto(VehicleMovement vehicleMovement) {
		
		return VehicleMovementDto.builder()
				.id(vehicleMovement.getId())
				.dateStart(vehicleMovement.getDateStart().toString())
				.dateEnd(vehicleMovement.getDateEnd().toString())
				.remarks(vehicleMovement.getRemarks())
				.locationStartid(vehicleMovement.getLocationStartid().getId())
				.locationEndid(vehicleMovement.getLocationEndid().getId())
				//.vehicleid(vehicleMovement.getVehicleid().getId())
				//.name(vehicleMovement.getVehicleid().getName())
				.build();
	}
	
	public VehicleMovement mapDtoToObject(VehicleMovementDto vehicleMovementDto) {
		LocalDate start = LocalDate.parse(vehicleMovementDto.getDateStart());
		Instant instantStart = start.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		LocalDate end = LocalDate.parse(vehicleMovementDto.getDateEnd());
		Instant instantEnd = end.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		return VehicleMovement.builder()
				.remarks(vehicleMovementDto.getRemarks())
				.dateEnd(instantEnd)
				.dateStart(instantStart)
				.build();
	}
	
	/*
	 * delete VehicleMovement by id
	 */
	@Transactional
	public void delete(Long id) {
		vehicleMovementRepository.deleteById(id);
	}
}
