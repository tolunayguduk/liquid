package com.liquid.auth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.liquid.auth.config.FeignClientConfiguration;
import com.liquid.auth.dto.AuthDto;
import com.liquid.auth.dto.KeyCloakDto;

@FeignClient(name = "keycloak", url = "${feign.client.list.keycloak}", configuration = FeignClientConfiguration.class)
public interface KeyCloakClient {

	@RequestMapping(method = RequestMethod.POST, value = "/token", consumes = "application/x-www-form-urlencoded")
	public AuthDto token(@RequestBody KeyCloakDto dto);
	
	@RequestMapping(method = RequestMethod.POST, value = "/logout", consumes = "application/x-www-form-urlencoded")
	public AuthDto terminate(@RequestBody KeyCloakDto dto);
	
	@RequestMapping(method = RequestMethod.POST, value = "/token/introspect", consumes = "application/x-www-form-urlencoded")
	public AuthDto introspect(@RequestBody KeyCloakDto dto);

}
