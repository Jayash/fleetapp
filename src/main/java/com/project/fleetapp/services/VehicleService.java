package com.project.fleetapp.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.fleetapp.dto.VehicleDto;
import com.project.fleetapp.exceptions.FleetappException;
import com.project.fleetapp.models.Employee;
import com.project.fleetapp.models.Location;
import com.project.fleetapp.models.Vehicle;
import com.project.fleetapp.models.VehicleMake;
import com.project.fleetapp.models.VehicleModel;
import com.project.fleetapp.models.VehicleStatus;
import com.project.fleetapp.models.VehicleType;
import com.project.fleetapp.repositories.EmployeeRepository;
import com.project.fleetapp.repositories.LocationRepository;
import com.project.fleetapp.repositories.VehicleMakeRepository;
import com.project.fleetapp.repositories.VehicleModelRepository;
import com.project.fleetapp.repositories.VehicleRepository;
import com.project.fleetapp.repositories.VehicleStatusRepository;
import com.project.fleetapp.repositories.VehicleTypeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VehicleService {

	private final VehicleRepository vehicleRepository;
	private final VehicleTypeRepository vehicleTypeRepository;
	private final VehicleStatusRepository vehicleStatusRepository;
	private final VehicleModelRepository vehicleModelRepository;
	private final EmployeeRepository employeeRepository;
	private final LocationRepository locationRepository;
	private final VehicleMakeRepository vehicleMakeRepository;
	
	/*
	 * Return All vehicle
	 */
	@Transactional
	public List<VehicleDto> getAll() {
		
		return vehicleRepository.findAll()
				.stream()
				.map(this::mapObjectToDto)
				.collect(Collectors.toList());
		//return vehicleRepository.findAll();
	}
	
	/*
	 * add a new vehicle
	 */
	@Transactional
	public void save(VehicleDto vehicleDto) {
		
		Location location = locationRepository.findById(vehicleDto.getLocationid())
								.orElseThrow(() -> new FleetappException("location not found"));
		
		VehicleStatus vehicleStatus = vehicleStatusRepository.findById(vehicleDto.getVehicleStatueid())
								.orElseThrow(() -> new FleetappException("vehicle Status not found"));
		
		VehicleType vehicleType = vehicleTypeRepository.findById(vehicleDto.getVehicleTypeid())
				.orElseThrow(() -> new FleetappException("vehicle Type not found"));
		
		VehicleModel vehicleModel = vehicleModelRepository.findById(vehicleDto.getVehicleModelid())
				.orElseThrow(() -> new FleetappException("vehicle Model not found"));
		
		Employee employee = employeeRepository.findById(vehicleDto.getEmployeeid())
				.orElseThrow(() -> new FleetappException("employee not found"));
		
		VehicleMake vehicleMake = vehicleMakeRepository.findById(vehicleDto.getVehicleMakeid())
				.orElseThrow(() -> new FleetappException("vehicle Make not found"));

		
		Vehicle vehicle = mapDtoToObject(vehicleDto);
		vehicle.setLocationid(location);
		vehicle.setVehicleModelid(vehicleModel);
		vehicle.setVehicleStatueid(vehicleStatus);
		vehicle.setVehicleTypeid(vehicleType);
		vehicle.setEmployeeid(employee);
		vehicle.setVehicleMakeid(vehicleMake);
		vehicleRepository.save(vehicle);
	}
	
	/*
	 * find vehicle by id
	 */
	@Transactional
	public VehicleDto findById(Long id) {
		Vehicle vehicle = vehicleRepository.findById(id).
				orElseThrow(() -> new FleetappException("vehicle not found"));
		
		return mapObjectToDto(vehicle);
	}
	
	/*
	 * update vehicle by id
	 */
	@Transactional
	public void update(VehicleDto vehicleDto) {
		LocalDate registration = LocalDate.parse(vehicleDto.getRegistrationDate());
		Instant registrationDate = registration.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		LocalDate acqusation = LocalDate.parse(vehicleDto.getAcquisationDate());
		Instant acquisationDate = acqusation.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		
		Vehicle vehicle = vehicleRepository.findById(vehicleDto.getId()).
				orElseThrow(() -> new FleetappException("vehicle not found"));

		
		Location location = locationRepository.findById(vehicleDto.getLocationid())
				.orElseThrow(() -> new FleetappException("location not found"));

		VehicleStatus vehicleStatus = vehicleStatusRepository.findById(vehicleDto.getVehicleStatueid())
				.orElseThrow(() -> new FleetappException("vehicle Status not found"));

		VehicleType vehicleType = vehicleTypeRepository.findById(vehicleDto.getVehicleTypeid())
				.orElseThrow(() -> new FleetappException("vehicle Type not found"));

		VehicleModel vehicleModel = vehicleModelRepository.findById(vehicleDto.getVehicleModelid())
				.orElseThrow(() -> new FleetappException("vehicle Model not found"));

		Employee employee = employeeRepository.findById(vehicleDto.getEmployeeid())
				.orElseThrow(() -> new FleetappException("employee not found"));
		
		VehicleMake vehicleMake = vehicleMakeRepository.findById(vehicleDto.getVehicleMakeid())
				.orElseThrow(() -> new FleetappException("vehicle Make not found"));
		
		vehicle.setLocationid(location);
		vehicle.setVehicleModelid(vehicleModel);
		vehicle.setVehicleStatueid(vehicleStatus);
		vehicle.setVehicleTypeid(vehicleType);
		vehicle.setEmployeeid(employee);
		vehicle.setRegistrationDate(registrationDate);
		vehicle.setAcquisationDate(acquisationDate);
		vehicle.setName(vehicleDto.getName());
		vehicle.setVehicleNumber(vehicleDto.getVehicleNumber());
		vehicle.setDescription(vehicleDto.getDescription());
		vehicle.setVehicleMakeid(vehicleMake);
		vehicle.setRemarks(vehicleDto.getRemarks());
		vehicle.setPower(vehicleDto.getPower());
		vehicle.setFuelCapacity(vehicleDto.getFuelCapacity());
		vehicle.setNetWeight(vehicleDto.getNetWeight());
		vehicleRepository.save(vehicle);
	}
	
	public VehicleDto mapObjectToDto(Vehicle vehicle) {
		
		return VehicleDto.builder()
				.id(vehicle.getId())
				.locationid(vehicle.getLocationid().getId())
				.vehicleModelid(vehicle.getVehicleModelid().getId())
				.vehicleNumber(vehicle.getVehicleNumber())
				.vehicleStatueid(vehicle.getVehicleStatueid().getId())
				.vehicleTypeid(vehicle.getVehicleTypeid().getId())
				.acquisationDate(vehicle.getAcquisationDate().toString())
				.registrationDate(vehicle.getRegistrationDate().toString())
				.name(vehicle.getName())
				.remarks(vehicle.getRemarks())
				.description(vehicle.getDescription())
				.employeeid(vehicle.getEmployeeid().getId())
				.vehicleMakeid(vehicle.getVehicleMakeid().getId())
				.netWeight(vehicle.getNetWeight())
				.fuelCapacity(vehicle.getFuelCapacity())
				.power(vehicle.getPower())
				.build();
	}
	
	public Vehicle mapDtoToObject(VehicleDto vehicleDto) {
		
		LocalDate registration = LocalDate.parse(vehicleDto.getRegistrationDate());
		Instant registrationDate = registration.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		LocalDate acqusation = LocalDate.parse(vehicleDto.getAcquisationDate());
		Instant acquisationDate = acqusation.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		
		return Vehicle.builder()
				.remarks(vehicleDto.getRemarks())
				.acquisationDate(acquisationDate)
				.registrationDate(registrationDate)
				.name(vehicleDto.getName())
				.description(vehicleDto.getDescription())
				.vehicleNumber(vehicleDto.getVehicleNumber())
				.power(vehicleDto.getPower())
				.netWeight(vehicleDto.getNetWeight())
				.fuelCapacity(vehicleDto.getFuelCapacity())
				.build();
	}
	
	/*
	 * delete Vehicle by id
	 */
	@Transactional
	public void delete(Long id) {
		vehicleRepository.deleteById(id);
	}

}
