package com.liquid.user.service;

import com.liquid.user.entity.AddressEntity;

public interface AddressService {

	AddressEntity find(Long id);
	
	AddressEntity create(AddressEntity entity);
	
	AddressEntity update(Long id, AddressEntity entity);

	void delete(Long id);

}
