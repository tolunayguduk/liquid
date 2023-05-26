package com.liquid.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeyCloakDto {
	private String client_id;
	private String client_secret;
	private String grant_type;
	private String scope;
	private String username;
	private String password;
	private String access_token;
	private String refresh_token;
	private String token;
	private Boolean active;
}
