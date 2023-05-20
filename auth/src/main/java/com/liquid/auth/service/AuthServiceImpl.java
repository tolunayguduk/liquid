package com.liquid.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liquid.auth.client.KeyCloakClient;
import com.liquid.auth.dto.AuthDto;
import com.liquid.auth.dto.CredentialDto;
import com.liquid.auth.dto.KeyCloakDto;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private KeyCloakClient keyCloakClient;

	@Override
	public AuthDto login(CredentialDto credential) {
		return keyCloakClient.token(new KeyCloakDto("liquid", "password", "openid", credential.getUsername(), credential.getPassword(), null, null));
	}

	@Override
	public boolean logout(String token) {


		
		Object auth = keyCloakClient.terminate(new KeyCloakDto("liquid", null, null, null, null, null, token));
		
		
		return true;
	}
	
	
	

}
