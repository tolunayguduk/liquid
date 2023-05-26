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
		return keyCloakClient.token(new KeyCloakDto("liquid", "eRRfHXTESe2PwCD9eqH1o0KVFLjc9cKe", "password", "openid", credential.getUsername(), credential.getPassword(), null, null, null, null));
	}

	@Override
	public AuthDto logout(AuthDto dto) {
		return keyCloakClient.terminate(new KeyCloakDto("liquid", "eRRfHXTESe2PwCD9eqH1o0KVFLjc9cKe", null, null, null, null, null, dto.getRefresh_token(), null, null));
		
	}
	
	public AuthDto introspect(AuthDto dto) {
		return keyCloakClient.introspect(new KeyCloakDto("liquid", "eRRfHXTESe2PwCD9eqH1o0KVFLjc9cKe", null, null, null, null, null, null, dto.getToken(), null));
	}

}
