package com.liquid.user.service;

import java.util.List;

import com.liquid.user.entity.UserRoleEntity;
import com.liquid.util.exception.CustomException;

public interface UserRoleService {

	UserRoleEntity find(Long id) throws CustomException;

	List<UserRoleEntity> list() throws CustomException;

	UserRoleEntity create(Long userId, UserRoleEntity entity) throws CustomException;

	UserRoleEntity delete(Long id) throws CustomException;

	UserRoleEntity update(Long id, UserRoleEntity entity) throws CustomException;

}
