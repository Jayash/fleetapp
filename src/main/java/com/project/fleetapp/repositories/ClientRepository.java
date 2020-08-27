package com.project.fleetapp.repositories;

import com.project.fleetapp.models.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
