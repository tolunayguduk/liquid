package com.liquid.auth.service;

import com.liquid.auth.client.KeyCloakClient;
import com.liquid.auth.request.KeyCloakRequest;
import com.liquid.auth.response.KeyCloakResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
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
    public KeyCloakResponse login(String username, String password) {
        return keyCloakClient.token(new KeyCloakRequest(client_id, client_secret, authorization_grant_type, scope, username, password, null, null, null, null));
    }

    @Override
    public ResponseEntity<?> logout(String refresh_token) {
        return keyCloakClient.terminate(new KeyCloakRequest(client_id, client_secret, null, null, null, null, null, refresh_token, null, null));

    }

    public ResponseEntity<?> introspect(String access_token) {
        return keyCloakClient.introspect(new KeyCloakRequest(client_id, client_secret, null, null, null, null, null, null, access_token, null));
    }

}