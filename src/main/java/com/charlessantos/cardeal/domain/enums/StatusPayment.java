package com.charlessantos.cardeal.domain.enums;

public enum StatusPayment {
	PENDING(1, "Pending"),
	PAID(2, "Paid"),
	CANCELED(3, "Canceled");
	
	private Integer code;
	private String description;
	
	private StatusPayment(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return this.code;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public static StatusPayment toEnum(Integer code) {
		if(code == null)
			return null;
		
		for(StatusPayment status : StatusPayment.values()) {
			if(code.equals(status.getCode()))
				return status;
		}
		
		throw new IllegalArgumentException("Status Payment not found for code: " + code);
	}
}
