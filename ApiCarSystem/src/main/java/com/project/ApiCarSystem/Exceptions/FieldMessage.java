package com.project.ApiCarSystem.Exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable {	

	private static final long serialVersionUID = 1L;
	
	private String fieldName;
	private String message;
	private String errorCode;

	public FieldMessage() {
	}

	public FieldMessage(String fieldName, String message, String errorCode) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
