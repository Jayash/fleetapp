package com.project.fleetapp.models;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Builder
@EqualsAndHashCode(callSuper=false)
public class VehicleModel extends CommonObject {

}
