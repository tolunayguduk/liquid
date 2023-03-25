package com.liquid.util.exception;

import org.springframework.http.HttpStatus;

public enum Exception {
	
	USER_NOT_FOUND(1000L, "Kullanıcı bulunamadı.", HttpStatus.NOT_FOUND),
	ROLE_NOT_FOUND(2000L, "Rol bulunamadı.", HttpStatus.NOT_FOUND),
	PASSWORD_NOT_FOUND(3000L, "Parola bulunamadı.", HttpStatus.NOT_FOUND);
	
	private Long code;
	private String explanation;
	private HttpStatus status;
	
	
	private Exception(long code, String explanation, HttpStatus status) {
		this.setCode(code);
		this.setExplanation(explanation);
		this.setStatus(status);
	}


	public long getCode() {
		return code;
	}


	public void setCode(long code) {
		this.code = code;
	}


	public String getExplanation() {
		return explanation;
	}


	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}


	public HttpStatus getStatus() {
		return status;
	}


	public void setStatus(HttpStatus status) {
		this.status = status;
	}


	public CustomException raise() {
		return ExceptionService.exception(this);
	}
	
	public static Exception getException(Long code) {
        for (Exception b : Exception.values()) {
            if (b.code.equals(code)) {
                return b;
            }
        }
        return null;
    }

}
