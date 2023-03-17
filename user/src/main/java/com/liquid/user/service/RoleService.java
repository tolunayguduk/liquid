package com.liquid.user.service;

import java.util.List;

import com.liquid.user.entity.RoleEntity;

public interface RoleService {

	RoleEntity find(Long id);

	List<RoleEntity> list();

	RoleEntity create(RoleEntity role);

	RoleEntity delete(Long id);

	RoleEntity update(Long id, RoleEntity role);

}
