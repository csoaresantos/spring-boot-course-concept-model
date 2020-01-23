package com.charlessantos.cardeal.domain.enums;

public enum VehicleFuelType {
	ALCOHOL(1, "ÁLCOOL"),
	BIFUEL(2, "BIFUEL"),
	DIEZEL(3, "DIEZEL"),
	GAZOLINE(4, "GAZOLINE"),
	GAZOLINE_GAS(5, "GAZOLINE + KIT GAS"),
	GAS(6, "GAS"),
	TETRA_FUEL(7, "TETRA FUEL");

	private Integer code;
	private String description;
	
	private VehicleFuelType(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static VehicleFuelType toEnum(Integer code) {
		if(code == null)
			return null;
		
		for(VehicleFuelType fuelType: VehicleFuelType.values()) {
			if(code.equals(fuelType.getCode()))
				return fuelType;
		}

		throw new IllegalArgumentException("Tipo de combustível inválido para o código: " + code);
	}
}
