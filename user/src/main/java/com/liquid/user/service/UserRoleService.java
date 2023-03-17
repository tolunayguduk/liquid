package com.liquid.user.service;

import java.util.List;

import com.liquid.user.entity.UserRoleEntity;

public interface UserRoleService {

	UserRoleEntity find(Long id);

	List<UserRoleEntity> list();

	UserRoleEntity create(Long userId, UserRoleEntity userRole);

	UserRoleEntity delete(Long id);

	UserRoleEntity update(Long id, UserRoleEntity userRole);

}
