package com.charlessantos.cardeal.dto;

import java.io.Serializable;

import com.charlessantos.cardeal.domain.Vehicle;

public class VehicleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String licensePlate;
	private Integer manufacturingYear;
	private Integer modelYear;
	private String version;

	public VehicleDTO(Integer id, String licensePlate, Integer manufacturingYear, Integer modelYear, String version) {
		super();
		this.id = id;
		this.licensePlate = licensePlate;
		this.manufacturingYear = manufacturingYear;
		this.modelYear = modelYear;
		this.version = version;
	}

	public VehicleDTO(Vehicle vehicle) {
		this.id = vehicle.getId();
		this.licensePlate = vehicle.getLicensePlate();
		this.manufacturingYear = vehicle.getManufacturingYear();
		this.modelYear = vehicle.getModelYear();
		this.version = vehicle.getVersion();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public Integer getManufacturingYear() {
		return manufacturingYear;
	}

	public void setManufacturingYear(Integer manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}

	public Integer getModelYear() {
		return modelYear;
	}

	public void setModelYear(Integer modelYear) {
		this.modelYear = modelYear;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	
}
