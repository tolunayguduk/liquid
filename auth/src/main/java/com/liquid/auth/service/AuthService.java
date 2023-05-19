package com.liquid.auth.service;

import com.liquid.auth.dto.AuthDto;
import com.liquid.auth.dto.CredentialDto;

public interface AuthService {

	public AuthDto login(CredentialDto credential);
}
