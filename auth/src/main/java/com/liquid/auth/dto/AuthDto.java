package com.liquid.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthDto {
	private String access_token;
	private String refresh_token;
	private String expires_in;
	private String refresh_expires_in;
	private String token_type;
}
