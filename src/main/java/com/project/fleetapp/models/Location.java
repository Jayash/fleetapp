package com.project.fleetapp.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Location {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String description;
	private String details;
	
	@ManyToOne(targetEntity = Country.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "countryid", referencedColumnName = "id")
	private Country countryid;
	
	@ManyToOne(targetEntity = State.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "stateid", referencedColumnName = "id")
	private State stateid;
	
	private String city;
	private String address;
	
}
