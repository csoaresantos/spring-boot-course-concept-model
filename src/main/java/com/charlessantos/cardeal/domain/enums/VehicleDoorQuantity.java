package com.charlessantos.cardeal.domain.enums;

public enum VehicleDoorQuantity {
	ONE_DOOR(1, "1 Porta"),
	TWO_DOOR(2, "2 Portas"),
	THREE_DOOR(3, "3 Portas"),
	FOUR_DOOR(4, "4 Portas"),
	FIVE_DOOR(5, "5 Portas"),
	SIX_DOOR(6, "6 Portas");
	
	private Integer code;
	private String description;
	
	private VehicleDoorQuantity(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
	public static VehicleDoorQuantity toEnum(Integer code) {
		if(code == null)
			return null;

		for(VehicleDoorQuantity doorQty : VehicleDoorQuantity.values()) {
			if(code.equals(doorQty.getCode()))
				return doorQty;
		}

		throw new IllegalArgumentException("Não foi encontrado nenhuma informação com o código informado: " + code);
	}
}
