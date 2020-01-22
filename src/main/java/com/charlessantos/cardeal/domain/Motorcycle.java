package com.charlessantos.cardeal.domain;

import javax.persistence.Entity;

@Entity
public class Motorcycle extends Vehicle {
	private static final long serialVersionUID = 1L;
	
	private Integer cylinders;

	public Motorcycle() {}

	public Motorcycle(Integer id, String licensePlate, VehicleModel model, Integer manufacturingYear,
			Integer modelYear, String version, Integer cylinders) {
		super(id, licensePlate, model, manufacturingYear, modelYear, version);
		
		this.cylinders = cylinders;
	}

	public Integer getCylinders() {
		return cylinders;
	}

	public void setCylinders(Integer cylinders) {
		this.cylinders = cylinders;
	}
	
	
}
