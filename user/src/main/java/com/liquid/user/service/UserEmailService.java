package com.liquid.user.service;

import com.liquid.user.entity.UserEmailEntity;

public interface UserEmailService {

	UserEmailEntity create(Long userId, UserEmailEntity email);

	UserEmailEntity update(Long id, UserEmailEntity email);

	void delete(Long id);

}
