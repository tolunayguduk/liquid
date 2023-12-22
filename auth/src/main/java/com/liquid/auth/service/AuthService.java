package com.liquid.auth.service;

import com.liquid.auth.dto.TokenDto;
import org.springframework.security.oauth2.jwt.Jwt;

public interface AuthService {

    public Object login(String username, String password);
    public Object introspect(Jwt jwt);
    public Object refresh(TokenDto token);
    public Object logout(TokenDto token);
}
