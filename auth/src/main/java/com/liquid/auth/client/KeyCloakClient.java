package com.liquid.auth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.liquid.auth.config.FeignClientConfiguration;
import com.liquid.auth.dto.AuthDto;
import com.liquid.auth.service.AuthServiceImpl;

@FeignClient(name = "keycloak", url = "${feign.client.list.keycloak}", configuration = FeignClientConfiguration.class)
public interface KeyCloakClient {

	@RequestMapping(method = RequestMethod.POST, value = "/token", consumes = "application/x-www-form-urlencoded")
	public AuthDto token(AuthServiceImpl.Header header);

}
