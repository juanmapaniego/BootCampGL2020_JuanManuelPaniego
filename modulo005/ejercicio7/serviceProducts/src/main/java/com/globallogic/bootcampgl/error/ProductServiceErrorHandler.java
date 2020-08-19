package com.globallogic.bootcampgl.error;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductServiceErrorHandler {
	private final String HTTP_MESSAGE_NOT_READABLE_MESSAGE = "ERROR EN DATOS ESPERADOS";
	private final String METHOD_ARGUMENT_NOT_VALID_MESSAGE = "ERROR MENSAJE MAL FORMADO";
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseJsonError> httpMessageNotReadableExceptionHandler(HttpServletRequest request){
		return ResponseEntity.badRequest().body(ResponseJsonError.builder()
				.status_code(HttpStatus.BAD_REQUEST.value())
				.message(HTTP_MESSAGE_NOT_READABLE_MESSAGE)
				.uri(request.getRequestURI())
				.build());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseJsonError> errorHandler(HttpServletRequest request){
		return ResponseEntity.badRequest().body(ResponseJsonError.builder()
				.status_code(HttpStatus.BAD_REQUEST.value())
				.message(METHOD_ARGUMENT_NOT_VALID_MESSAGE)
				.uri(request.getRequestURI())
				.build());
	}
}
