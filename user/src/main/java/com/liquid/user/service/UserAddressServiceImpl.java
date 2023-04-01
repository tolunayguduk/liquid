package com.liquid.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liquid.user.entity.AddressEntity;
import com.liquid.user.entity.UserAddressEntity;
import com.liquid.user.repository.AddressRepository;
import com.liquid.user.repository.UserAddressRepository;
import com.liquid.user.repository.UserRepository;
import com.liquid.util.exception.CustomException;
import com.liquid.util.exception.Exception;

@Service
public class UserAddressServiceImpl implements UserAddressService {

	@Autowired
	private UserAddressRepository userAddressRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private UserRepository userRepository;
	

	@Override
	public List<AddressEntity> find(Long userId) throws CustomException {
		List<UserAddressEntity> userAddresses = userAddressRepository.findByUserId(userId).orElseThrow(() -> Exception.ADDRESS_NOT_FOUND.raise());
		return userAddresses.stream().map(UserAddressEntity::getAddress).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void create(Long userId, Long addressId) {
		UserAddressEntity userAddressEntity = new UserAddressEntity();

		userAddressEntity.setUser(userRepository.findOneById(userId).orElseThrow(() -> Exception.USER_NOT_FOUND.raise()));
		userAddressEntity.setAddress(addressRepository.findOneById(addressId).orElseThrow(() -> Exception.ADDRESS_NOT_FOUND.raise()));
		
		userAddressRepository.save(userAddressEntity);
	}
	
	@Override
	@Transactional
	public void create(Long userId, AddressEntity entity) {
		UserAddressEntity userAddressEntity = new UserAddressEntity();
		AddressEntity address = addressRepository.save(entity);
		
		userAddressEntity.setUser(userRepository.findOneById(userId).orElseThrow(() -> Exception.USER_NOT_FOUND.raise()));
		userAddressEntity.setAddress(address);
		
		userAddressRepository.save(userAddressEntity);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		userAddressRepository.deleteOneById(id).get();
	}

}
