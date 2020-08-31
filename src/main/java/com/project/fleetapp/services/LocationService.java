package com.project.fleetapp.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.fleetapp.dto.LocationDto;
import com.project.fleetapp.exceptions.FleetappException;
import com.project.fleetapp.models.Country;
import com.project.fleetapp.models.Location;
import com.project.fleetapp.models.State;
import com.project.fleetapp.repositories.CountryRepository;
import com.project.fleetapp.repositories.LocationRepository;
import com.project.fleetapp.repositories.StateRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LocationService {
	
	private final LocationRepository locationRepository;
	private final StateRepository stateRepository;
	private final CountryRepository countryRepository;
	
	/*
	 * Return All Location
	 */
	@Transactional
	public List<Location> getAll() {
		return locationRepository.findAll();
	}
	
	/*
	 * add a new Location
	 */
	@Transactional
	public void save(LocationDto locationDto) {
		Country country = countryRepository.findById(locationDto.getCountryid())
								.orElseThrow(() -> new FleetappException("country not found"));
		
		State state = stateRepository.findById(locationDto.getStateid())
								.orElseThrow(() -> new FleetappException("state not found"));
		
		Location location = mapDtoToObject(locationDto);
		location.setCountryid(country);
		location.setStateid(state);
		locationRepository.save(location);
	}
	
	/*
	 * find Location by id
	 */
	@Transactional
	public LocationDto findById(Long id) {
		Location location = locationRepository.findById(id).
				orElseThrow(() -> new FleetappException("location not found"));
		
		return mapObjectToDto(location);
	}
	
	/*
	 * update Location by id
	 */
	@Transactional
	public void update(LocationDto locationDto) {
		Location location = locationRepository.findById(locationDto.getId()).
				orElseThrow(() -> new FleetappException("location not found"));
		
		Country country = countryRepository.findById(locationDto.getCountryid())
				.orElseThrow(() -> new FleetappException("country not found"));
		
		State state = stateRepository.findById(locationDto.getStateid())
				.orElseThrow(() -> new FleetappException("state not found"));
		
		location.setDescription(locationDto.getDescription());
		location.setDetails(locationDto.getDetails());
		location.setCountryid(country);
		location.setStateid(state);
		location.setCity(locationDto.getCity());
		location.setAddress(locationDto.getAddress());
		
		locationRepository.save(location);
	}
	
	public LocationDto mapObjectToDto(Location location) {
		return LocationDto.builder()
				.id(location.getId())
				.description(location.getDescription())
				.details(location.getDetails())
				.countryid(location.getCountryid().getId())
				.stateid(location.getStateid().getId())
				.city(location.getCity())
				.address(location.getAddress())
				.build();
	}
	
	public Location mapDtoToObject(LocationDto locationDto) {
		return Location.builder()
				.description(locationDto.getDescription())
				.details(locationDto.getDetails())
				.city(locationDto.getCity())
				.address(locationDto.getAddress())
				.build();
	}
	
	/*
	 * delete Location by id
	 */
	@Transactional
	public void delete(Long id) {
		locationRepository.deleteById(id);
	}
}
