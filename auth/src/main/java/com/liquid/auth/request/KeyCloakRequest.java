package com.liquid.auth.request;

public class KeyCloakRequest {
    private String client_id;
    private String client_secret;
    private String grant_type;
    private String scope;
    private String username;
    private String password;
    private String access_token;
    private String refresh_token;
    private String token;
    private Boolean active;

    public KeyCloakRequest(String client_id, String client_secret, String grant_type, String scope, String username, String password, String access_token, String refresh_token, String token, Boolean active) {
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.grant_type = grant_type;
        this.scope = scope;
        this.username = username;
        this.password = password;
        this.access_token = access_token;
        this.refresh_token = refresh_token;
        this.token = token;
        this.active = active;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
