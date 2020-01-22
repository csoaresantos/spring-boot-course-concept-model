package com.charlessantos.cardeal.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String licensePlate;

	private Integer manufacturingYear;
	private Integer modelYear;
	private String version;

	@ManyToOne
	@JoinColumn(name="vehicle_model_id")
	private VehicleModel model;
	
	public Vehicle() {}
	
	public Vehicle(Integer id, String licensePlate, VehicleModel model, Integer manufacturingYear, Integer modelYear,
			String version) {
		super();
		this.id = id;
		this.licensePlate = licensePlate;
		this.model = model;
		this.manufacturingYear = manufacturingYear;
		this.modelYear = modelYear;
		this.version = version;
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
	
	public VehicleModel getModel() {
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
