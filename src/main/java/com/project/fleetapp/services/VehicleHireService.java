package com.project.fleetapp.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.fleetapp.dto.VehicleHireDto;
import com.project.fleetapp.exceptions.FleetappException;
import com.project.fleetapp.models.Client;
import com.project.fleetapp.models.Location;
import com.project.fleetapp.models.VehicleHire;
import com.project.fleetapp.repositories.ClientRepository;
import com.project.fleetapp.repositories.LocationRepository;
import com.project.fleetapp.repositories.VehicleHireRepository;
import com.project.fleetapp.repositories.VehicleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VehicleHireService {

	
	private final VehicleHireRepository vehicleHireRepository;
	private final VehicleRepository vehicleRepository;
	private final LocationRepository locationRepository;
	private final ClientRepository clientRepository;
	
	/*
	 * Return All vehicleHire
	 */
	@Transactional
	public List<VehicleHireDto> getAll() {
		
		return vehicleHireRepository.findAll()
				.stream()
				.map(this::mapObjectToDto)
				.collect(Collectors.toList());
		//return vehicleHireRepository.findAll();
	}
	
	/*
	 * add a new vehicleHire
	 */
	@Transactional
	public void save(VehicleHireDto vehicleHireDto) {
		/*Vehicle vehicle = vehicleRepository.findById(vehicleHireDto.getVehicleid())
								.orElseThrow(() -> new FleetappException("vehicle not found"));*/
		
		Location location = locationRepository.findById(vehicleHireDto.getLocationid())
								.orElseThrow(() -> new FleetappException("location not found"));
		Client client = clientRepository.findById(vehicleHireDto.getClientid())
								.orElseThrow(() -> new FleetappException("client not found"));
		
		VehicleHire vehicleHire = mapDtoToObject(vehicleHireDto);
		//vehicleHire.setVehicleid(vehicle);
		vehicleHire.setLocationid(location);
		vehicleHire.setClientid(client);
		vehicleHireRepository.save(vehicleHire);
	}
	
	/*
	 * find vehicleHire by id
	 */
	@Transactional
	public VehicleHireDto findById(Long id) {
		VehicleHire vehicleHire = vehicleHireRepository.findById(id).
				orElseThrow(() -> new FleetappException("vehicleHire not found"));
		
		return mapObjectToDto(vehicleHire);
	}
	
	/*
	 * update vehicleHire by id
	 */
	@Transactional
	public void update(VehicleHireDto vehicleHireDto) {
		LocalDate in = LocalDate.parse(vehicleHireDto.getDateIn());
		Instant dayIn = in.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		LocalDate out = LocalDate.parse(vehicleHireDto.getDateOut());
		Instant dayOut = out.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		
		VehicleHire vehicleHire = vehicleHireRepository.findById(vehicleHireDto.getId()).
				orElseThrow(() -> new FleetappException("vehicleHire not found"));
		
		/*Vehicle vehicle = vehicleRepository.findById(vehicleHireDto.getVehicleid())
				.orElseThrow(() -> new FleetappException("vehicle not found"));*/
		
		Location location = locationRepository.findById(vehicleHireDto.getLocationid())
				.orElseThrow(() -> new FleetappException("location not found"));
		Client client = clientRepository.findById(vehicleHireDto.getClientid())
				.orElseThrow(() -> new FleetappException("client not found"));
		
		//vehicleHire.setVehicleid(vehicle);
		vehicleHire.setDateIn(dayIn);
		vehicleHire.setDateOut(dayOut);;
		vehicleHire.setLocationid(location);
		vehicleHire.setClientid(client);
		//vehicleHire.setVehicleid(vehicle);
		vehicleHire.setRemarks(vehicleHireDto.getRemarks());
		
		vehicleHire.setTimeIn(vehicleHireDto.getTimeIn());
		vehicleHire.setTimeOut(vehicleHireDto.getTimeOut());
		vehicleHire.setPrice(vehicleHireDto.getPrice());

		vehicleHireRepository.save(vehicleHire);
	}
	
	public VehicleHireDto mapObjectToDto(VehicleHire vehicleHire) {
		
		return VehicleHireDto.builder()
				.id(vehicleHire.getId())
				.dateIn(vehicleHire.getDateIn().toString())
				.dateOut(vehicleHire.getDateOut().toString())
				.clientid(vehicleHire.getClientid().getId())
				.locationid(vehicleHire.getLocationid().getId())
				.timeIn(vehicleHire.getTimeIn())
				.timeOut(vehicleHire.getTimeOut())
				.price(vehicleHire.getPrice())
				.remarks(vehicleHire.getRemarks())
				//.vehicleid(vehicleHire.getVehicleid().getId())
				//.name(vehicleHire.getVehicleid().getName())
				.build();
	}
	
	public VehicleHire mapDtoToObject(VehicleHireDto vehicleHireDto) {
		LocalDate in = LocalDate.parse(vehicleHireDto.getDateIn());
		Instant dayIn = in.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		LocalDate out = LocalDate.parse(vehicleHireDto.getDateOut());
		Instant dayOut = out.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		return VehicleHire.builder()
				.remarks(vehicleHireDto.getRemarks())
				.price(vehicleHireDto.getPrice())
				.remarks(vehicleHireDto.getRemarks())
				.timeIn(vehicleHireDto.getTimeIn())
				.timeOut(vehicleHireDto.getTimeOut())
				.dateIn(dayIn)
				.dateOut(dayOut)
				.build();
	}
	
	/*
	 * delete VehicleHire by id
	 */
	@Transactional
	public void delete(Long id) {
		vehicleHireRepository.deleteById(id);
	}
}
