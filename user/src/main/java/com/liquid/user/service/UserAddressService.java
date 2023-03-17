package com.liquid.user.service;

import java.util.List;

import com.liquid.user.entity.UserAddressEntity;

public interface UserAddressService {

	UserAddressEntity find(Long id);

	List<UserAddressEntity> list();

	UserAddressEntity create(Long userId, UserAddressEntity address);

	UserAddressEntity delete(Long id);

	UserAddressEntity update(Long id, UserAddressEntity address);

}
