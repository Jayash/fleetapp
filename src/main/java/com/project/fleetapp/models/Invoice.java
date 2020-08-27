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
public class Invoice {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private Instant invoiceDate;
	
	@ManyToOne(targetEntity = InvoiceStatus.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "invoiceStatusid", referencedColumnName = "id", insertable = false, updatable = false)
	private InvoiceStatus invoiceStatusid;
	
	@ManyToOne(targetEntity = Client.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "clientid", referencedColumnName = "id", insertable = false, updatable = false)
	private Client clientid;
	
	private String remarks;
}
