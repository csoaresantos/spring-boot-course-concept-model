package com.charlessantos.cardeal.domain;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicle {
	private static final long serialVersionUID = 1L;
	
	private String engine;
	private String valve;
	private String door;
	private String color;
	private String fuel;
	private String kilometers;

	public Car() {}
	
	public Car(Integer id, String licensePlate, String brand, String model, Integer manufacturingYear, Integer modelYear,
			String version, String engine, String valve, String door, String color, String fuel, String kilometers) {
		super(id, licensePlate, brand, model, manufacturingYear, modelYear, version);
		this.engine = engine;
		this.valve = valve;
		this.door = door;
		this.color = color;
		this.fuel = fuel;
		this.kilometers = kilometers;
	}

	public String getEngine() {
		return engine;
	}
	
	public void setEngine(String engine) {
		this.engine = engine;
	}
	
	public String getValve() {
		return valve;
	}
	
	public void setValve(String valve) {
		this.valve = valve;
	}
	
	public String getDoor() {
		return door;
	}
	
	public void setDoor(String door) {
		this.door = door;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getFuel() {
		return fuel;
	}
	
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	
	public String getKilometers() {
		return kilometers;
	}
	
	public void setKilometers(String kilometers) {
		this.kilometers = kilometers;
	}
	
}
