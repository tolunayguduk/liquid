package com.liquid.report.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.liquid.report.dto.UserDto;

@FeignClient(name = "user", url = "${feign.client.list.user}")
public interface UserClient {

	@GetMapping("/find/id/{id}")
	public UserDto find(@PathVariable("id") Long id);
}
