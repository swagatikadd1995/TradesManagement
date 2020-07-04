package com.simpragma.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.simpragma.management.dto.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = InputValidationException.class)
	private  ResponseEntity<ErrorDto> exceptionHandle(InputValidationException exception) {
		ErrorDto errorDto = new ErrorDto();
		errorDto.setMessage(exception.getErrorMessage());
		return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
	}

	
	@ExceptionHandler(value = DataServiceException.class)
	private  ResponseEntity<ErrorDto> exceptionHandle(DataServiceException exception) {
		ErrorDto errorDto = new ErrorDto();
		errorDto.setMessage(exception.getErrorMessage());
		return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = InvalidDataServiceException.class)
	private  ResponseEntity<ErrorDto> exceptionHandle(InvalidDataServiceException exception) {
		ErrorDto errorDto = new ErrorDto();
		errorDto.setMessage(exception.getErrorMessage());
		return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
	}

}
