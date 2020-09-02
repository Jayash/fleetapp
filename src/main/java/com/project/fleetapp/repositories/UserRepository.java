package com.project.fleetapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.fleetapp.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public Optional<User> findByUsername(String username);
}
