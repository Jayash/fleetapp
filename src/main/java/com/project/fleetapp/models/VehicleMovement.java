package com.project.fleetapp.models;

import java.time.Instant;

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
public class VehicleMovement {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne(targetEntity = Vehicle.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicleid", referencedColumnName = "id")
	private Vehicle vehicleid;
	
	@ManyToOne(targetEntity = Location.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "locationStartid", referencedColumnName = "id")
	private Location locationStartid;
	
	private Instant dateStart;
	
	@ManyToOne(targetEntity = Location.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "locationEndid", referencedColumnName = "id")
	private Location locationEndid;
	
	private Instant dateEnd;
	
	private String remarks;
}
