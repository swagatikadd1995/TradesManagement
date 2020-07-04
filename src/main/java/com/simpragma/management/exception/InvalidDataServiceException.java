package com.simpragma.management.exception;

public class InvalidDataServiceException extends RuntimeException {

	private static final long serialVersionUID = 3609295296332548132L;

	private String errorMessage;

	public InvalidDataServiceException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
