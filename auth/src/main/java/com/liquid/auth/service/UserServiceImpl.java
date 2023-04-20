package com.liquid.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liquid.auth.client.UserClient;
import com.liquid.auth.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserClient userClient;
	
	@Override
	public UserDto find(Long id) {
		UserDto user = userClient.find(id);
		return user;
	}

}
