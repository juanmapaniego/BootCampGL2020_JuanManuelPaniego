package com.globallogic.bootcampgl.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductoErrorHandler {
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> illegalArgumentExceptionHandler(IllegalArgumentException e){
		return ResponseEntity.badRequest().body(e.getMessage());
	}
}
