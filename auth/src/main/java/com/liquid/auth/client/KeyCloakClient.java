package com.liquid.auth.client;

import com.liquid.auth.request.KeyCloakRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "keycloak", url = "${spring.security.oauth2.client.provider.liquid-provider.issuer-uri}")
public interface KeyCloakClient {

    @RequestMapping(method = RequestMethod.POST, value = "/protocol/openid-connect/token", consumes = "application/x-www-form-urlencoded")
    public Object token(@RequestBody KeyCloakRequest request);

    @RequestMapping(method = RequestMethod.POST, value = "/protocol/openid-connect/token", consumes = "application/x-www-form-urlencoded")
    public Object refresh(@RequestBody KeyCloakRequest request);

    @RequestMapping(method = RequestMethod.POST, value = "/protocol/openid-connect/logout", consumes = "application/x-www-form-urlencoded")
    public Object terminate(@RequestBody KeyCloakRequest request);

    @RequestMapping(method = RequestMethod.POST, value = "/protocol/openid-connect/token/introspect", consumes = "application/x-www-form-urlencoded")
    public Object introspect(@RequestBody KeyCloakRequest request);

}