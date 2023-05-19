package com.liquid.auth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.liquid.auth.config.FeignClientConfiguration;
import com.liquid.auth.dto.UserDto;

@FeignClient(name = "user", url = "${feign.client.list.user}", configuration = FeignClientConfiguration.class)
public interface UserClient {

	@GetMapping("/find/id/{id}")
	public UserDto find(@PathVariable("id") Long id);

}
