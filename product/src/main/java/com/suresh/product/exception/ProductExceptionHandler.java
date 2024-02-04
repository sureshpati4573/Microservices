package com.suresh.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.suresh.product.DTO.ProductResponse;

@ControllerAdvice
public class ProductExceptionHandler {
	
	@ExceptionHandler(value = ProductNotFoundException.class)	
	public ResponseEntity propertyNotFoundException(ProductNotFoundException e) {
		return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
