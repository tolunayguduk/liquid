package com.liquid.user.service;

import java.util.List;

import com.liquid.user.entity.UserEmailEntity;
import com.liquid.util.exception.CustomException;

public interface UserEmailService {

	List<UserEmailEntity> find(Long userId) throws CustomException;
	
	void create(Long userId, UserEmailEntity entity) throws CustomException;

	void update(Long userId, UserEmailEntity entity) throws CustomException;

	void delete(Long id) throws CustomException;

}
