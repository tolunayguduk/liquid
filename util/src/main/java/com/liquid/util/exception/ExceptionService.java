package com.liquid.util.exception;

public class ExceptionService {
	
	public static CustomException exception(Exception ex) {
		return new CustomException(String.valueOf(ex.getCode()));
	}
}
