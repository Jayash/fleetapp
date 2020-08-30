package com.project.fleetapp.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.fleetapp.dto.StateDto;
import com.project.fleetapp.exceptions.FleetappException;
import com.project.fleetapp.models.Country;
import com.project.fleetapp.models.State;
import com.project.fleetapp.repositories.CountryRepository;
import com.project.fleetapp.repositories.StateRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StateService {
	
	private final StateRepository stateRepository;
	private final CountryRepository countryRepository;
	
	/*
	 * Return All states
	 */
	@Transactional
	public List<State> getAll() {
		return stateRepository.findAll();
	}
	
	/*
	 * add a new state
	 */
	@Transactional
	public void save(StateDto stateDto) {
		Country country = countryRepository.findById(stateDto.getCountryid())
								.orElseThrow(() -> new FleetappException("country not found"));
		
		State state = mapDtoToObject(stateDto);
		state.setCountryid(country);
		stateRepository.save(state);
	}
	
	/*
	 * find state by id
	 */
	@Transactional
	public StateDto findById(Long id) {
		State state = stateRepository.findById(id).
				orElseThrow(() -> new FleetappException("state not found"));
		
		return mapObjectToDto(state);
	}
	
	/*
	 * update state by id
	 */
	@Transactional
	public void update(StateDto stateDto) {
		State state = stateRepository.findById(stateDto.getId()).
				orElseThrow(() -> new FleetappException("state not found"));
		
		Country country = countryRepository.findById(stateDto.getCountryid())
				.orElseThrow(() -> new FleetappException("country not found"));
		
		state.setCapital(stateDto.getCapital());
		state.setCode(stateDto.getCode());
		state.setCountryid(country);
		state.setName(stateDto.getName());
		state.setDetails(stateDto.getDetails());
		
		stateRepository.save(state);
	}
	
	public StateDto mapObjectToDto(State state) {
		return StateDto.builder()
				.id(state.getId())
				.capital(state.getCapital())
				.code(state.getCode())
				.countryid(state.getCountryid().getId())
				.name(state.getName())
				.details(state.getDetails())
				.build();
	}
	
	public State mapDtoToObject(StateDto stateDto) {
		return State.builder()
				.capital(stateDto.getCapital())
				.code(stateDto.getCode())
				.details(stateDto.getDetails())
				.name(stateDto.getName())
				.build();
	}
	
	/*
	 * delete state by id
	 */
	@Transactional
	public void delete(Long id) {
		stateRepository.deleteById(id);
	}
}
