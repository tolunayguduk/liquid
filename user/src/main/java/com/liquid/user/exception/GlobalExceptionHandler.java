package com.liquid.user.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.liquid.util.exception.CustomException;
import com.liquid.util.exception.Exception;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = CustomException.class)
	public ResponseEntity<?> exception(CustomException exception) {
		Exception ex = Exception.getException(Long.valueOf(exception.getMessage()));
		logger.info("(" + ex.getCode() + ") " + ex.getExplanation());
		return new ResponseEntity<>(ex.getExplanation(), ex.getStatus());
	}
	
	@ExceptionHandler()
	public ResponseEntity<?> exception(java.lang.Exception exception) {
		logger.info(exception.getLocalizedMessage());
		return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}