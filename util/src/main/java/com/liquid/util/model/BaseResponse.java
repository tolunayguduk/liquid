package com.liquid.util.model;

import com.liquid.util.constant.Constant;

import lombok.Data;

@Data
public class BaseResponse<T> {

	private Long code = Constant.DEFAULT_RESPONSE_CODE;
	private String explanation = Constant.DEFAULT_RESPONSE_EXPLANATION;
	private T result;
	
	public BaseResponse() {
		super();
	}
	
	public BaseResponse(T result) {
		super();
		this.result = result;
	}
	
	public BaseResponse(Long status, String explanation) {
		super();
		this.code = status;
		this.explanation = explanation;
	}
	
	public BaseResponse(Long status, String explanation, T result) {
		super();
		this.code = status;
		this.explanation = explanation;
		this.result = result;
	}
	
}
