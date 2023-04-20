package com.liquid.auth.service;

import com.liquid.auth.dto.UserDto;

public interface UserService {

	UserDto find(Long id);
}
