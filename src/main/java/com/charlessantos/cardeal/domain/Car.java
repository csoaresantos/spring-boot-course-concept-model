package com.charlessantos.cardeal.domain;

import javax.persistence.Entity;

import com.charlessantos.cardeal.domain.enums.VehicleColor;
import com.charlessantos.cardeal.domain.enums.VehicleDoorQuantity;
import com.charlessantos.cardeal.domain.enums.VehicleFuelType;

@Entity
public class Car extends Vehicle {
	private static final long serialVersionUID = 1L;
	
	private String engine;
	private String valve;
	private Integer door;
	private Integer color;
	private Integer fuel;
	private Integer kilometers;

	public Car() {}
	
	public Car(Integer id, String licensePlate, VehicleModel model, Integer manufacturingYear, Integer modelYear,
			String version, String engine, String valve, VehicleDoorQuantity door, VehicleColor color, VehicleFuelType fuel, Integer kilometers) {
		super(id, licensePlate, model, manufacturingYear, modelYear, version);
		this.engine = engine;
		this.valve = valve;
		this.door = door.getCode();
		this.color = color.getCode();
		this.fuel = fuel.getCode();
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
	
	public VehicleDoorQuantity getDoor() {
		return VehicleDoorQuantity.toEnum(door);
	}
	
	public void setDoor(VehicleDoorQuantity door) {
		this.door = door.getCode();
	}
	
	public VehicleColor getColor() {
		return VehicleColor.toEnum(color);
	}
	
	public void setColor(VehicleColor color) {
		this.color = color.getCode();
	}
	
	public VehicleFuelType getFuel() {
		return VehicleFuelType.toEnum(fuel);
	}
	
	public void setFuel(VehicleFuelType fuel) {
		this.fuel = fuel.getCode();
	}
	
	public Integer getKilometers() {
		return kilometers;
	}
	
	public void setKilometers(Integer kilometers) {
		this.kilometers = kilometers;
	}
	
}
