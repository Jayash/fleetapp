package com.project.fleetapp.models;

import java.time.Instant;

import javax.persistence.Column;
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
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class VehicleMaintenance {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@ManyToOne(targetEntity = Vehicle.class, fetch = FetchType.LAZY)
	@JoinColumn(name="vehicleid", referencedColumnName = "id")
	private Vehicle vehicleid;
	
	private Instant startDate;
	private Instant endDate;
	private String price;
	
	@ManyToOne(targetEntity = Supplier.class, fetch = FetchType.LAZY)
	@JoinColumn(name="supplierid", referencedColumnName = "id")
	private Supplier supplierid;
	
	private String remarks;
}
