package com.project.fleetapp.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.fleetapp.exceptions.FleetappException;
import com.project.fleetapp.models.Contact;
import com.project.fleetapp.repositories.ContactRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContactService {
	
	private final ContactRepository contactRepository;

	/*
	 * Return All Contact
	 */
	@Transactional
	public List<Contact> getAll() {
		return contactRepository.findAll();
	}

	/*
	 * add a new Contact
	 */
	@Transactional
	public void save(Contact contact) {
		contactRepository.save(contact);
	}

	/*
	 * find Contact by id
	 */
	@Transactional
	public Contact findById(Long id) {
		Contact contact = contactRepository.findById(id)
				.orElseThrow(() -> new FleetappException("contact not found"));

		return contact;
	}

	/*
	 * update Contact by id
	 */
	@Transactional
	public void update(Contact contact) {

		contactRepository.save(contact);
	}

	/*
	 * delete Contact by id
	 */
	@Transactional
	public void delete(Long id) {
		contactRepository.deleteById(id);
	}
}
