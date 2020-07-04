package com.simpragma.management.exception;

public class DataServiceException extends RuntimeException {

	private static final long serialVersionUID = 7959027513617405787L;

	private String errorMessage;

	public DataServiceException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
