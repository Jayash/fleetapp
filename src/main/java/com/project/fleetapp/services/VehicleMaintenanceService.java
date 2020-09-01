package com.project.fleetapp.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.fleetapp.dto.VehicleMaintenanceDto;
import com.project.fleetapp.exceptions.FleetappException;
import com.project.fleetapp.models.Supplier;
import com.project.fleetapp.models.VehicleMaintenance;
import com.project.fleetapp.repositories.SupplierRepository;
import com.project.fleetapp.repositories.VehicleMaintenanceRepository;
import com.project.fleetapp.repositories.VehicleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VehicleMaintenanceService {
	
	private final VehicleMaintenanceRepository vehicleMaintenanceRepository;
	private final VehicleRepository vehicleRepository;
	private final SupplierRepository supplierRepository;
	
	/*
	 * Return All vehicleMaintenance
	 */
	@Transactional
	public List<VehicleMaintenance> getAll() {
		return vehicleMaintenanceRepository.findAll();
	}
	
	/*
	 * add a new vehicleMaintenance
	 */
	@Transactional
	public void save(VehicleMaintenanceDto vehicleMaintenanceDto) {
		/*Vehicle vehicle = vehicleRepository.findById(vehicleMaintenanceDto.getVehicleid())
								.orElseThrow(() -> new FleetappException("vehicle not found"));*/
		
		Supplier supplier = supplierRepository.findById(vehicleMaintenanceDto.getSupplierid())
								.orElseThrow(() -> new FleetappException("supplier not found"));
		
		VehicleMaintenance vehicleMaintenance = mapDtoToObject(vehicleMaintenanceDto);
		//vehicleMaintenance.setVehicleid(vehicle);
		vehicleMaintenance.setSupplierid(supplier);
		vehicleMaintenanceRepository.save(vehicleMaintenance);
	}
	
	/*
	 * find vehicleMaintenance by id
	 */
	@Transactional
	public VehicleMaintenanceDto findById(Long id) {
		VehicleMaintenance vehicleMaintenance = vehicleMaintenanceRepository.findById(id).
				orElseThrow(() -> new FleetappException("vehicleMaintenance not found"));
		
		return mapObjectToDto(vehicleMaintenance);
	}
	
	/*
	 * update vehicleMaintenance by id
	 */
	@Transactional
	public void update(VehicleMaintenanceDto vehicleMaintenanceDto) {
		LocalDate date1 = LocalDate.parse(vehicleMaintenanceDto.getStartDate());
		Instant instant1 = date1.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		LocalDate date2 = LocalDate.parse(vehicleMaintenanceDto.getEndDate());
		Instant instant2 = date2.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		VehicleMaintenance vehicleMaintenance = vehicleMaintenanceRepository.findById(vehicleMaintenanceDto.getId()).
				orElseThrow(() -> new FleetappException("vehicleMaintenance not found"));
		
		/*Vehicle vehicle = vehicleRepository.findById(vehicleMaintenanceDto.getVehicleid())
				.orElseThrow(() -> new FleetappException("vehicle not found"));*/
		
		Supplier supplier = supplierRepository.findById(vehicleMaintenanceDto.getSupplierid())
				.orElseThrow(() -> new FleetappException("supplier not found"));
		
		//vehicleMaintenance.setVehicleid(vehicle);
		vehicleMaintenance.setSupplierid(supplier);
		vehicleMaintenance.setStartDate(instant1);
		vehicleMaintenance.setEndDate(instant2);
		vehicleMaintenance.setPrice(vehicleMaintenanceDto.getPrice());
		vehicleMaintenance.setRemarks(vehicleMaintenanceDto.getRemarks());

		vehicleMaintenanceRepository.save(vehicleMaintenance);
	}
	
	public VehicleMaintenanceDto mapObjectToDto(VehicleMaintenance vehicleMaintenance) {
		
		return VehicleMaintenanceDto.builder()
				.id(vehicleMaintenance.getId())
				.startDate(vehicleMaintenance.getStartDate().toString())
				.endDate(vehicleMaintenance.getEndDate().toString())
				.price(vehicleMaintenance.getPrice())
				.remarks(vehicleMaintenance.getRemarks())
				.supplierid(vehicleMaintenance.getSupplierid().getId())
				//.vehicleid(vehicleMaintenance.getVehicleid().getId())
				//.name(vehicleMaintenance.getVehicleid().getName())
				.build();
	}
	
	public VehicleMaintenance mapDtoToObject(VehicleMaintenanceDto vehicleMaintenanceDto) {
		LocalDate date1 = LocalDate.parse(vehicleMaintenanceDto.getStartDate());
		Instant instant1 = date1.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		LocalDate date2 = LocalDate.parse(vehicleMaintenanceDto.getEndDate());
		Instant instant2 = date2.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		return VehicleMaintenance.builder()
				.remarks(vehicleMaintenanceDto.getRemarks())
				.price(vehicleMaintenanceDto.getPrice())
				.startDate(instant1)
				.endDate(instant2)
				.build();
	}
	
	/*
	 * delete VehicleMaintenance by id
	 */
	@Transactional
	public void delete(Long id) {
		vehicleMaintenanceRepository.deleteById(id);
	}
	
}
