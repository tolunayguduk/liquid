package com.liquid.report.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.liquid.util.exception.CustomException;
import com.liquid.util.exception.Exception;
import com.liquid.util.model.BaseResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = CustomException.class)
	public ResponseEntity<?> exception(CustomException exception) {
		Exception ex = Exception.getException(Long.valueOf(exception.getMessage()));
		logger.info("(" + ex.getCode() + ") " + ex.getExplanation());
		return new ResponseEntity<>(new BaseResponse<Object>(ex.getCode(), ex.getExplanation()), HttpStatus.OK);
	}

	@ExceptionHandler(value = java.lang.Exception.class)
	public ResponseEntity<?> exception(java.lang.Exception exception) {
		logger.info(exception.getLocalizedMessage());
		return new ResponseEntity<>(new BaseResponse<Object>(0L, exception.getLocalizedMessage()), HttpStatus.OK);
	}

}