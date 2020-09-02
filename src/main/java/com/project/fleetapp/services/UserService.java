package com.project.fleetapp.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.fleetapp.models.User;
import com.project.fleetapp.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	/*
	 * add a new user
	 */
	@Transactional
	public void save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
}
