package com.liquid.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public void create(Long userId, UserAddressEntity entity) {
		entity.setUser(userRepository.findOneById(userId).orElseThrow(() -> Exception.USER_NOT_FOUND.raise()));
		userAddressRepository.save(entity);
	}

	@Override
	@Transactional
	public UserAddressEntity update(Long id, UserAddressEntity entity) {
		UserAddressEntity currentEntity = userAddressRepository.findOneById(id).orElseThrow(() -> Exception.ADDRESS_NOT_FOUND.raise());
		currentEntity.load(entity);
		return userAddressRepository.save(currentEntity);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		userAddressRepository.deleteOneById(id).get();
	}

}
