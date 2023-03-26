package com.liquid.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liquid.user.entity.AddressEntity;
import com.liquid.user.entity.UserAddressEntity;
import com.liquid.user.repository.UserAddressRepository;
import com.liquid.user.repository.UserRepository;
import com.liquid.util.exception.Exception;

@Service
public class UserAddressServiceImpl implements UserAddressService {

	@Autowired
	private UserAddressRepository userAddressRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public void create(Long userId, AddressEntity entity) {
		UserAddressEntity userAddressEntity = new UserAddressEntity();
		userAddressEntity.setUser(userRepository.findOneById(userId).orElseThrow(() -> Exception.USER_NOT_FOUND.raise()));
		userAddressEntity.setAddress(entity);
		userAddressRepository.save(userAddressEntity);
	}

	@Override
	@Transactional
	public void update(Long id, AddressEntity entity) {
		UserAddressEntity currentEntity = userAddressRepository.findOneById(id).orElseThrow(() -> Exception.ADDRESS_NOT_FOUND.raise());
		currentEntity.getAddress().load(entity);
		userAddressRepository.save(currentEntity);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		userAddressRepository.deleteOneById(id).get();
	}

}
