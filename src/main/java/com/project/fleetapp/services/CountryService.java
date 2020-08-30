package com.project.fleetapp.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.fleetapp.exceptions.FleetappException;
import com.project.fleetapp.models.Country;
import com.project.fleetapp.repositories.CountryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CountryService {
	
	private final CountryRepository countryRepository;
	
	/*
	 * Return All Countries
	 */
	@Transactional
	public List<Country> getAll() {
		return countryRepository.findAll();
	}
	
	/*
	 * add a new country
	 */
	@Transactional
	public void save(Country country) {
		countryRepository.save(country);
	}
	
	
	/*
	 * find country by id
	 */
	@Transactional
	public Country findById(Long id) {
		Country country = countryRepository.findById(id).
				orElseThrow(() -> new FleetappException("Country not found"));
		
		return country;
	}
	
	/*
	 * delete conutry by id
	 */
	@Transactional
	public void delete(Long id) {
		countryRepository.deleteById(id);
	}
}
