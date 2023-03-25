package com.liquid.user.service;

import com.liquid.user.entity.UserAddressEntity;

public interface UserAddressService {

	UserAddressEntity create(Long userId, UserAddressEntity address);
	
	UserAddressEntity update(Long id, UserAddressEntity address);

	void delete(Long id);

}
