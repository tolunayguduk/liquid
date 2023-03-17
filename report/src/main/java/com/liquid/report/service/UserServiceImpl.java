package com.liquid.report.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liquid.report.client.UserClient;
import com.liquid.report.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserClient userClient;
	
	@Override
	public UserDto find(Long id) {
		UserDto user = userClient.find(id).getResult();
		return user;
	}

}
