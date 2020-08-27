package com.project.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.fleetapp.models.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
