package com.project.fleetapp.models;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Employee extends Person {
	
	@ManyToOne(targetEntity = EmployeeType.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "employeetypeid", referencedColumnName = "id", updatable = false, insertable = false)
	private EmployeeType employeetypeid;
	
	private String photo;
	private String username;

	@ManyToOne(targetEntity = JobTitle.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "jobTitleid", referencedColumnName = "id", updatable = false, insertable = false)
	private JobTitle jobTitleid;
	
	private Instant hireDate;

}
