package com.liquid.user.service;

import java.util.List;

import com.liquid.user.entity.RoleEntity;
import com.liquid.util.exception.CustomException;

public interface UserRoleService {

	List<RoleEntity> find(Long userId) throws CustomException;
	
	void create(Long userId, Long roleId) throws CustomException;

	void delete(Long id) throws CustomException;

}
