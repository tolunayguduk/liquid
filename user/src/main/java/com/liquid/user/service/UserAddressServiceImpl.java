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
	public UserAddressEntity create(Long userId, UserAddressEntity address) {
		address.setUser(userRepository.findOneById(userId).orElseThrow(() -> Exception.USER_NOT_FOUND.raise()));
		return userAddressRepository.save(address);
	}

	@Override
	@Transactional
	public UserAddressEntity update(Long id, UserAddressEntity userAddress) {
		UserAddressEntity currentUserAddress = userAddressRepository.findOneById(id).orElseThrow(() -> Exception.ADDRESS_NOT_FOUND.raise());
		currentUserAddress.load(userAddress);
		return userAddressRepository.save(currentUserAddress);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		userAddressRepository.deleteOneById(id).get();
	}

}
