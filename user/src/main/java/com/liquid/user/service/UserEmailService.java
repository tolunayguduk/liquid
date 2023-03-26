package com.liquid.user.service;

import com.liquid.user.entity.UserEmailEntity;
import com.liquid.util.exception.CustomException;

public interface UserEmailService {

	void create(Long userId, UserEmailEntity entity) throws CustomException;

	void update(Long userId, UserEmailEntity entity) throws CustomException;

	void delete(Long id) throws CustomException;

}
