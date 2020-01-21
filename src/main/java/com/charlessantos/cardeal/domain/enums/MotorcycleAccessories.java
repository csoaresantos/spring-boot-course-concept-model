package com.charlessantos.cardeal.domain.enums;

public enum MotorcycleAccessories {
	ABS(1, "ABS"),
	ALARME(2, "ALARME"),
	AMORTECEDOR_DE_DIRECAO(3, "AMORTECEDOR DE DIREÇÃO"),
	BAGAGEIRO(4, "BAGAGEIRO"),
	CARENAGEM(5, "CARENAGEM"),
	COMPUTADOR_DE_BORDO(6, "COMPUTADOR DE BORDO"),
	CONTROLE_DE_TRACAO(7, "CONTROLE DE TRAÇÃO"),
	DESCANSO_CENTRAL(8, "DESCANSO CENTRAL"),
	ESCAPAMENTO_ESPORTIVO(9, "ESCAPAMENTO ESPORTIVO"),
	FAROIS_LED(10, "FARÓIS LED"),
	FREIOS_A_DDISCO(11, "FREIOS À DISCO"),
	INJECAO_ELETRONICA(12, "INJEÇÃO ELETRONICA"),
	PARTIDA_ELETRICA(13, "PARTIDA ELÉTRICA"),
	PNEU_ESPECIAL(14, "PNEU ESPECIAL"),
	RODAS(15, "RODAS"),
	TRAVAS(16, "TRAVAS");
	
	private Integer code;
	private String description;

	private MotorcycleAccessories(Integer code, String description) {
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

	public static VehicleAccessories toEnum(Integer code) {
		if(null == code) {
			return null;
		}
		
		for(VehicleAccessories accessory : VehicleAccessories.values()) {
			if(code.equals(accessory.getCode())) {
				return accessory;
			}
		}
		
		throw new IllegalArgumentException("Invalid Type Accessory value: " + code);
	}
}
