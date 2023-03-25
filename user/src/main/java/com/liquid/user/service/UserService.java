package com.liquid.user.service;

import java.util.List;

import com.liquid.user.entity.UserEntity;
import com.liquid.util.exception.CustomException;

public interface UserService {

	List<UserEntity> list();

	UserEntity find(Long id) throws CustomException;

	UserEntity find(String username) throws CustomException;
	
	UserEntity create(UserEntity user) throws CustomException;

	UserEntity update(Long id, UserEntity user) throws CustomException;

	void delete(Long id) throws CustomException;

}
