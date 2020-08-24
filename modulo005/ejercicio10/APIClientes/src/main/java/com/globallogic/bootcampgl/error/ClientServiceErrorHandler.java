package com.globallogic.bootcampgl.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.converter.HttpMessageNotReadableException;

@ControllerAdvice
public class ClientServiceErrorHandler {
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	protected ResponseEntity<String> HttpMessageNotReadableException(HttpMessageNotReadableException ex) {

		return new ResponseEntity<String>("Error, mensaje mal Formado", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> runtimeExceptionHandler(RuntimeException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
}
