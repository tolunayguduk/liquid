package com.liquid.user.service;

import java.util.List;

import com.liquid.user.entity.UserEmailEntity;

public interface UserEmailService {

	UserEmailEntity find(Long id);

	List<UserEmailEntity> list();

	UserEmailEntity create(Long userId, UserEmailEntity email);

	UserEmailEntity delete(Long id);

	UserEmailEntity update(Long id, UserEmailEntity email);

}
