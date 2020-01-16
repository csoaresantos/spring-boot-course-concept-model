package com.charlessantos.cardeal.domain.enums;

public enum TypeClient {
	PHYSICALPERSON(1, "Physical Person"),
	LEGALPERSON(2, "Legal Person");

	private Integer code;
	private String description;
	
	private TypeClient(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public Integer getCode() {
		return this.code;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public static TypeClient toEnum(Integer code) {
		if(code == null)
			return null;
		
		for(TypeClient type : TypeClient.values()) {
			if(code.equals(type.getCode()))
				return type;
		}
		
		throw new IllegalArgumentException("Invalid Type Client value: " + code);
	}
}
