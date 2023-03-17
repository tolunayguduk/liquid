package com.liquid.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liquid.user.entity.UserAddressEntity;
import com.liquid.user.entity.UserEntity;
import com.liquid.user.repository.UserAddressRepository;
import com.liquid.user.repository.UserRepository;

@Service
public class UserAddressServiceImpl implements UserAddressService {

	@Autowired
	private UserAddressRepository userAddressRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserAddressEntity find(Long id) {
		Optional<UserAddressEntity> address = userAddressRepository.findOneById(id);
		return address.get();
	}

	@Override
	public List<UserAddressEntity> list() {
		return userAddressRepository.findAll();
	}

	@Override
	public UserAddressEntity create(Long userId, UserAddressEntity address) {
		address.setUser(userRepository.findOneById(userId).orElse(new UserEntity()));
		return userAddressRepository.save(address);
	}

	@Override
	public UserAddressEntity update(Long id, UserAddressEntity address) {
		return userAddressRepository.save(address);
	}

	@Override
	public UserAddressEntity delete(Long id) {
		return userAddressRepository.deleteOneById(id).get();
	}

}
