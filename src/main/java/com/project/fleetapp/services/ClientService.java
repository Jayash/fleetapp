package com.project.fleetapp.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.fleetapp.dto.ClientDto;
import com.project.fleetapp.exceptions.FleetappException;
import com.project.fleetapp.models.Client;
import com.project.fleetapp.models.Country;
import com.project.fleetapp.models.State;
import com.project.fleetapp.repositories.ClientRepository;
import com.project.fleetapp.repositories.CountryRepository;
import com.project.fleetapp.repositories.StateRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService {
	
	private final ClientRepository clientRepository;
	private final StateRepository stateRepository;
	private final CountryRepository countryRepository;
	
	/*
	 * Return All client
	 */
	@Transactional
	public List<Client> getAll() {
		return clientRepository.findAll();
	}
	
	/*
	 * add a new client
	 */
	@Transactional
	public void save(ClientDto clientDto) {
		Country country = countryRepository.findById(clientDto.getCountryid())
								.orElseThrow(() -> new FleetappException("country not found"));
		
		State state = stateRepository.findById(clientDto.getStateid())
								.orElseThrow(() -> new FleetappException("state not found"));
		
		Client client = mapDtoToObject(clientDto);
		client.setCountryid(country);
		client.setStateid(state);
		clientRepository.save(client);
	}
	
	/*
	 * find client by id
	 */
	@Transactional
	public ClientDto findById(Long id) {
		Client client = clientRepository.findById(id).
				orElseThrow(() -> new FleetappException("client not found"));
		
		return mapObjectToDto(client);
	}
	
	/*
	 * update client by id
	 */
	@Transactional
	public void update(ClientDto clientDto) {
		Client client = clientRepository.findById(clientDto.getId()).
				orElseThrow(() -> new FleetappException("client not found"));
		
		Country country = countryRepository.findById(clientDto.getCountryid())
				.orElseThrow(() -> new FleetappException("country not found"));
		
		State state = stateRepository.findById(clientDto.getStateid())
				.orElseThrow(() -> new FleetappException("state not found"));
		
		client.setDetails(clientDto.getDetails());
		client.setCountryid(country);
		client.setStateid(state);
		client.setCity(clientDto.getCity());
		client.setAddress(clientDto.getAddress());
		client.setPhone(clientDto.getPhone());
		client.setMobile(clientDto.getMobile());
		client.setWebsite(clientDto.getWebsite());
		client.setEmail(clientDto.getEmail());
		client.setName(clientDto.getName());

		clientRepository.save(client);
	}
	
	public ClientDto mapObjectToDto(Client client) {
		return ClientDto.builder()
				.id(client.getId())
				.details(client.getDetails())
				.countryid(client.getCountryid().getId())
				.stateid(client.getStateid().getId())
				.city(client.getCity())
				.address(client.getAddress())
				.phone(client.getPhone())
				.mobile(client.getMobile())
				.website(client.getWebsite())
				.email(client.getEmail())
				.name(client.getName())
				.build();
	}
	
	public Client mapDtoToObject(ClientDto clientDto) {
		return Client.builder()
				.phone(clientDto.getPhone())
				.details(clientDto.getDetails())
				.city(clientDto.getCity())
				.address(clientDto.getAddress())
				.mobile(clientDto.getMobile())
				.email(clientDto.getEmail())
				.website(clientDto.getWebsite())
				.name(clientDto.getName())
				.build();
	}
	
	/*
	 * delete Client by id
	 */
	@Transactional
	public void delete(Long id) {
		clientRepository.deleteById(id);
	}
}
