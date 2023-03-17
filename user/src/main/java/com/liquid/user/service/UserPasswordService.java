package com.liquid.user.service;

import java.util.List;

import com.liquid.user.entity.UserPasswordEntity;

public interface UserPasswordService {

	UserPasswordEntity find(Long id);

	List<UserPasswordEntity> list();

	UserPasswordEntity create(Long userId, UserPasswordEntity password);

	UserPasswordEntity delete(Long id);

	UserPasswordEntity update(Long id, UserPasswordEntity password);

}
