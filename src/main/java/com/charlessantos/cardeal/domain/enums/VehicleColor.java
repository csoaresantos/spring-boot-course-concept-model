package com.charlessantos.cardeal.domain.enums;

public enum VehicleColor {
	AMARELOC(1, "AMARELO");
	
	private Integer code;
	private String description;
	
	private VehicleColor(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static VehicleColor toEnum(Integer code) {
		if(code == null)
			return null;
		
		for(VehicleColor color : VehicleColor.values()) {
			if(code.equals(color.getCode())) {
				return color;
			}
		}
		
		throw new IllegalArgumentException("Não localizamos nenhuma cor com o código informado: " + code);
	}
}
