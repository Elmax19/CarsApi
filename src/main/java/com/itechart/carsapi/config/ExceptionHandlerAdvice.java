package com.itechart.carsapi.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = { AccessDeniedException.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException e, WebRequest request) {
		String errorMsg = e.getLocalizedMessage();
		return handleExceptionInternal(e, errorMsg, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
	}
}