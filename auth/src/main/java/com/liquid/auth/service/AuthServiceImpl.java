package com.liquid.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liquid.auth.client.KeyCloakClient;
import com.liquid.auth.dto.AuthDto;
import com.liquid.auth.dto.CredentialDto;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private KeyCloakClient keyCloakClient;

	@Override
	public AuthDto login(CredentialDto credential) {
		return keyCloakClient.token(new Header("liquid", "password", "openid", credential.getUsername(), credential.getPassword()));
	}
	
	
	public class Header{
		
		
		public Header(String client_id, String grant_type, String scope, String username, String password) {
			super();
			this.client_id = client_id;
			this.grant_type = grant_type;
			this.scope = scope;
			this.username = username;
			this.password = password;
		}
		
		String client_id;
		String grant_type;
		String scope;
		String username;
		String password;
	}

}
