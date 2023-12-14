package com.liquid.auth.service;

public interface AuthService {

    public Object login(String username, String password);

    public Object logout(String refresh_token);

    public Object introspect(String access_token);
}
