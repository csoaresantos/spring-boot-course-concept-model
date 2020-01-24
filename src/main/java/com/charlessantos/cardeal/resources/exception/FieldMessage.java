package com.charlessantos.cardeal.resources.exception;

import java.io.Serializable;

public class FieldMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fieldName;
	private String message;

	public FieldMessage(String fieldName, String fieldDescription) {
		super();
		this.fieldName = fieldName;
		this.message = fieldDescription;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldDescription() {
		return message;
	}

	public void setFieldDescription(String fieldDescription) {
		this.message = fieldDescription;
	}

	
}
