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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String name;
	
	@ManyToOne(targetEntity = VehicleType.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicleTypeid", referencedColumnName = "id", insertable = false, updatable = false)
	private VehicleType vehicleTypeid;
	
	private String vehicleNumber;
	private Instant registrationDate;
	private Instant acquisationDate;
	private String description;
	
	@ManyToOne(targetEntity = VehicleStatus.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicleStatueid", referencedColumnName = "id", updatable = false, insertable = false)
	private VehicleStatus vehicleStatueid;
	
	@ManyToOne(targetEntity = Employee.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "employeeid", referencedColumnName = "id", updatable = false, insertable = false)
	private Employee employeeid;

	@ManyToOne(targetEntity = VehicleModel.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicleModelid", referencedColumnName = "id", updatable = false, insertable = false)
	private VehicleModel vehicleModelid;
	
	@ManyToOne(targetEntity = Location.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "locationid", referencedColumnName = "id", updatable = false, insertable = false)
	private Location locationid;
	
	private String remarks;
	
	
	
}
