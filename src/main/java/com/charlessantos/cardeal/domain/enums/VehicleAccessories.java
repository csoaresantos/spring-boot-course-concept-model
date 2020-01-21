package com.charlessantos.cardeal.domain.enums;

public enum VehicleAccessories {
	
	SEVEN_SEATS(1, "7 Lugares"),
	ABS(2, "ABS"),
	AIR_BAGS_1(3, "AIR BAGS 1"),
	AIR_BAGS_2(4, "AIR BAGS 2"),
	AIR_BAGS_PLUS(5, "AIR BAGS + 2"),
	ALARME(15, "ALARME"),
	AR_CONDICIONADO(16, "AR CONDICIONADO"),
	AR_QUENTE(17, "AR QUENTE"),
	BANCOS_DE_COURO(19, "BANCOS_DE_COURO"),
	BLINDADO(20, "BLINDADO"),
	CAMBIO_AUTOMATIZADO(21, "CAMBIO_AUTOMATIZADO"),
	CAPOTA_MARITIMA(22, "CAPOTA_MARÍTIMA"),
	CD_MP3(23, "CD / MP3"),
	CENTRAL_MULTIMIDIA(24, "CENTRAL_MULTIMIDIA"),
	COMPUTADOR_DE_BORDO(25, "COMPUTADOR_DE_BORDO"),
	CONTROLE_ESTABILIDADE(26, "CONTROLE_ESTABILIDADE"),
	CONTROLE_TRACAO(27, "CONTROLE_TRAÇÃO"),
	CONVERSIVEL(28, "CONVERSÍVEL"),
	CAMBIO_AUTOMATICO(29, "CÂMBIO_AUTOMÁTICO"),
	CAMBIO_MANUAL(30, "CÂMBIO_MANUAL"),
	CAMERA_DE_RE(31, "CÂMERA_DE_RÉ"),
	DESEMBACADOR(32, "DESEMBAÇADOR"),
	DIRECAO_ELETRICA(33, "DIREÇÃO_ELÉTRICA"),
	DIRECAO_HIDRAULICA(34, "DIREÇÃO_HIDRÁULICA"),
	DVD(35, "DVD"),
	ENGATE(36, "ENGATE"),
	FAROL_XENONIO(37, "FAROL_XENÔNIO"),
	FAROIS_AUXILIARES(38, "FARÓIS_AUXILIARES"),
	FAROIS_LED(39, "FARÓIS_LED"),
	GPS(40, "GPS"),
	LIMPADOR_RASEIRO(41, "LIMPADOR_RASEIRO"),
	MP3_USB(42, "MP3 / USB"),
	PILOTO_AUTOMATICO(43, "PILOTO_AUTOMÁTICO"),
	PROTETOR_DE_CACAMBA(44, "PROTETOR_DE_CAÇAMBA"),
	REBAIXADO(45, "REBAIXADO"),
	RETROVISORES_ELETRICOS(46, "RETROVISORES_ELÉTRICOS"),
	RODAS_DE_LIGA_LEVE(47, "RODAS_DE_LIGA_LEVE"),
	SENSOR_DE_RE(48, "SENSOR_DE_RÉ"),
	TETO_SOLAR(49, "TETO_SOLAR"),
	TRAVAS_ELETRICAS(50, "TRAÇÃO_4X4"),
	TRACAO_4X4(51, ""),
	TURBO(52, "TURBO"),
	VIDROS_ELETRICOS(53, "VIDROS ELÉTRICOS"),
	VOLANTE_AJUSTAVEL(54, "VOLANTE AJUSTÁVEL");
	
	private Integer code;
	private String description;

	private VehicleAccessories(Integer code, String description) {
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
