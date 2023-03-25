package com.liquid.user.service;

import com.liquid.user.entity.UserPasswordEntity;
import com.liquid.util.exception.CustomException;

public interface UserPasswordService {

	UserPasswordEntity create(Long userId, UserPasswordEntity entity) throws CustomException;

	UserPasswordEntity update(Long id, UserPasswordEntity entity) throws CustomException;

	void delete(Long id) throws CustomException;

}
