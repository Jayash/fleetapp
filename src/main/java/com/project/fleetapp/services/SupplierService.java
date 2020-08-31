package com.project.fleetapp.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.fleetapp.dto.SupplierDto;
import com.project.fleetapp.exceptions.FleetappException;
import com.project.fleetapp.models.Country;
import com.project.fleetapp.models.State;
import com.project.fleetapp.models.Supplier;
import com.project.fleetapp.repositories.CountryRepository;
import com.project.fleetapp.repositories.StateRepository;
import com.project.fleetapp.repositories.SupplierRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SupplierService {
	
	private final SupplierRepository supplierRepository;
	private final StateRepository stateRepository;
	private final CountryRepository countryRepository;
	
	/*
	 * Return All Supplier
	 */
	@Transactional
	public List<Supplier> getAll() {
		return supplierRepository.findAll();
	}
	
	/*
	 * add a new Supplier
	 */
	@Transactional
	public void save(SupplierDto supplierDto) {
		Country country = countryRepository.findById(supplierDto.getCountryid())
								.orElseThrow(() -> new FleetappException("country not found"));
		
		State state = stateRepository.findById(supplierDto.getStateid())
								.orElseThrow(() -> new FleetappException("state not found"));
		
		Supplier supplier = mapDtoToObject(supplierDto);
		supplier.setCountryid(country);
		supplier.setStateid(state);
		supplierRepository.save(supplier);
	}
	
	/*
	 * find Supplier by id
	 */
	@Transactional
	public SupplierDto findById(Long id) {
		Supplier supplier = supplierRepository.findById(id).
				orElseThrow(() -> new FleetappException("supplier not found"));
		
		return mapObjectToDto(supplier);
	}
	
	/*
	 * update Supplier by id
	 */
	@Transactional
	public void update(SupplierDto supplierDto) {
		Supplier supplier = supplierRepository.findById(supplierDto.getId()).
				orElseThrow(() -> new FleetappException("supplier not found"));
		
		Country country = countryRepository.findById(supplierDto.getCountryid())
				.orElseThrow(() -> new FleetappException("country not found"));
		
		State state = stateRepository.findById(supplierDto.getStateid())
				.orElseThrow(() -> new FleetappException("state not found"));
		
		supplier.setDetails(supplierDto.getDetails());
		supplier.setCountryid(country);
		supplier.setStateid(state);
		supplier.setCity(supplierDto.getCity());
		supplier.setAddress(supplierDto.getAddress());
		supplier.setPhone(supplierDto.getPhone());
		supplier.setMobile(supplierDto.getMobile());
		supplier.setWebsite(supplierDto.getWebsite());
		supplier.setEmail(supplierDto.getEmail());
		supplier.setName(supplierDto.getName());
		
		supplierRepository.save(supplier);
	}
	
	public SupplierDto mapObjectToDto(Supplier supplier) {
		return SupplierDto.builder()
				.id(supplier.getId())
				.details(supplier.getDetails())
				.countryid(supplier.getCountryid().getId())
				.stateid(supplier.getStateid().getId())
				.city(supplier.getCity())
				.address(supplier.getAddress())
				.phone(supplier.getPhone())
				.mobile(supplier.getMobile())
				.website(supplier.getWebsite())
				.email(supplier.getEmail())
				.name(supplier.getName())
				.build();
	}
	
	public Supplier mapDtoToObject(SupplierDto supplierDto) {
		return Supplier.builder()
				.phone(supplierDto.getPhone())
				.details(supplierDto.getDetails())
				.city(supplierDto.getCity())
				.address(supplierDto.getAddress())
				.mobile(supplierDto.getMobile())
				.email(supplierDto.getEmail())
				.website(supplierDto.getWebsite())
				.name(supplierDto.getName())
				.build();
	}
	
	/*
	 * delete Supplier by id
	 */
	@Transactional
	public void delete(Long id) {
		supplierRepository.deleteById(id);
	}
}
