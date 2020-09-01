package com.project.fleetapp.models;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleHire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne(targetEntity = Vehicle.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicleid", referencedColumnName = "id")
	private Vehicle vehicleid;
	
	private Instant dateOut;
	private String timeOut;
	private Instant dateIn;
	private String timeIn;
	
	@ManyToOne(targetEntity = Client.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "clientid", referencedColumnName = "id")
	private Client clientid;
	
	@ManyToOne(targetEntity = Location.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "locationid", referencedColumnName = "id")
	private Location locationid;
	
	private String price;
	
	private String remarks;
}
