package com.liquid.user.service;

import java.util.List;

import com.liquid.user.entity.AddressEntity;
import com.liquid.util.exception.CustomException;

public interface UserAddressService {

	List<AddressEntity> find(Long userId) throws CustomException;
	
	void create(Long userId, AddressEntity entity) throws CustomException;

	void update(Long userId, Long addressId, AddressEntity entity) throws CustomException;

	void delete(Long id) throws CustomException;

}
