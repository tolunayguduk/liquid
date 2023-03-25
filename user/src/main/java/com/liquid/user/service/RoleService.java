package com.liquid.user.service;

import java.util.List;

import com.liquid.user.entity.RoleEntity;
import com.liquid.util.exception.CustomException;

public interface RoleService {

	RoleEntity find(Long id) throws CustomException;

	List<RoleEntity> list() throws CustomException;

	RoleEntity create(RoleEntity entity) throws CustomException;

	RoleEntity delete(Long id) throws CustomException;

	RoleEntity update(Long id, RoleEntity entity) throws CustomException;

}
