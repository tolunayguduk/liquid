package com.liquid.user.service;

import com.liquid.user.entity.UserAddressEntity;
import com.liquid.util.exception.CustomException;

public interface UserAddressService {

	UserAddressEntity create(Long userId, UserAddressEntity entity) throws CustomException;

	UserAddressEntity update(Long id, UserAddressEntity entity) throws CustomException;

	void delete(Long id) throws CustomException;

}
