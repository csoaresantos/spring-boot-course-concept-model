package com.charlessantos.cardeal.domain.enums;

public enum VehicleColor {
	AMARELO(1, "AMARELO"),
	AZUL(2,"AZUL"),
	BEGE(3,"BEGE"),
	BRANCO(4,"BRANCO"),
	BRONZE(5,"BRONZE"),
	CINZA(6,"CINZA"),
	DOURADO(7,"DOURADO"),
	LARANJA(8,"LARANJA"),
	MARROM(9,"MARROM"),
	PRATA(10,"PRATA"),
	PRETO(11,"PRETO"),
	ROSA(12,"ROSA"),
	ROXO(13,"ROXO"),
	VERDE(14,"VERDE"),
	VERMELHO(15,"VERMELHO"),
	VINHO(16,"VINHO");

	private Integer code;
	private String description;
	
	private VehicleColor(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
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
