package com.liquid.user.service;

import com.liquid.user.entity.UserEmailEntity;
import com.liquid.util.exception.CustomException;

public interface UserEmailService {

	UserEmailEntity create(Long userId, UserEmailEntity entity) throws CustomException;

	UserEmailEntity update(Long id, UserEmailEntity entity) throws CustomException;

	void delete(Long id) throws CustomException;

}
