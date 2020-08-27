package com.project.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.fleetapp.models.State;

public interface StateRepository extends JpaRepository<State, Long> {

}
