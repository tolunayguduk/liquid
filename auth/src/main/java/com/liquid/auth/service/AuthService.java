package com.liquid.auth.service;

import com.liquid.auth.dto.TokenDto;

public interface AuthService {

    public Object login(String username, String password);
    public Object refresh(TokenDto token);
    public Object logout(TokenDto token);
    public Object introspect(TokenDto token);
}
