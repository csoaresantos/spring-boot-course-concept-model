package com.charlessantos.cardeal.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.charlessantos.cardeal.domain.Vehicle;
import com.charlessantos.cardeal.domain.VehicleModel;

public class VehicleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message="Preenchimento obrigatório!")
	@Length(min=7, max=7, message="Campo de tamanho igual a 7!")
	private String licensePlate;
	private Integer manufacturingYear;

	private Integer modelYear;

	private String version;
	private VehicleModel model;

	public VehicleDTO(Integer id, String licensePlate, VehicleModel model, Integer manufacturingYear, Integer modelYear, String version) {
		super();
		this.id = id;
		this.licensePlate = licensePlate;
		this.model = model;
		this.manufacturingYear = manufacturingYear;
		this.modelYear = modelYear;
		this.version = version;
	}

	public VehicleDTO(Vehicle vehicle) {
		this.id = vehicle.getId();
		this.licensePlate = vehicle.getLicensePlate();
		this.model = vehicle.getModel();
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

	public VehicleModel getVehicleModel() {
		return model;
	}
	
	public void setVehicleModel(VehicleModel model) {
		this.model = model;
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
