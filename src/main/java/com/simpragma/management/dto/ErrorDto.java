package com.simpragma.management.dto;

import java.io.Serializable;

public class ErrorDto implements Serializable {

	private static final long serialVersionUID = 1816590202466342430L;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
