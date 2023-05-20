package com.liquid.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeyCloakDto {
	String client_id;
	String grant_type;
	String scope;
	String username;
	String password;
	String access_token;
	String refresh_token;
}
