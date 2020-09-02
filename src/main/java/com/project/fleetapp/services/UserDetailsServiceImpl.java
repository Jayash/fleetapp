package com.project.fleetapp.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.fleetapp.exceptions.FleetappException;
import com.project.fleetapp.models.User;
import com.project.fleetapp.models.UserPrincipal;
import com.project.fleetapp.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new FleetappException("user not found"));
		
		return new UserPrincipal(user);
	}
	

}
