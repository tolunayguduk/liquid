package com.liquid.auth.service;

import com.liquid.auth.client.KeyCloakClient;
import com.liquid.auth.dto.TokenDto;
import com.liquid.auth.request.KeyCloakRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Value("${spring.security.oauth2.client.registration.keycloak-spring-gateway-client.client-id}")
    private String client_id;

    @Value("${spring.security.oauth2.client.registration.keycloak-spring-gateway-client.client-secret}")
    private String client_secret;

    @Value("${spring.security.oauth2.client.registration.keycloak-spring-gateway-client.authorization-grant-type}")
    private String authorization_grant_type;

    @Value("${spring.security.oauth2.client.registration.keycloak-spring-gateway-client.scope}")
    private String scope;


    @Autowired
    private KeyCloakClient keyCloakClient;

    @Override
    public Object login(String username, String password) {
        return keyCloakClient.token(new KeyCloakRequest(client_id, client_secret, authorization_grant_type, scope, username, password, null, null, null, null));
    }

    @Override
    public Object logout(TokenDto token) {
        return keyCloakClient.terminate(new KeyCloakRequest(client_id, client_secret, null, null, null, null, null, token.getRefresh_token(), null, null));

    }

    public Object introspect(TokenDto token) {
        return keyCloakClient.introspect(new KeyCloakRequest(client_id, client_secret, null, null, null, null, null, null, token.getAccess_token(), null));
    }

}