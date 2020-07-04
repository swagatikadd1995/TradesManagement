package com.simpragma.management.exception;

public class InputValidationException  extends RuntimeException{

	
	private static final long serialVersionUID = 5791537170728440135L;
	
	private String errorMessage;
	
	public InputValidationException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
