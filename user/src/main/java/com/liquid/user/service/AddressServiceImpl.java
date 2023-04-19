package com.liquid.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liquid.user.entity.AddressEntity;
import com.liquid.user.repository.AddressRepository;
import com.liquid.util.exception.Exception;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	@Transactional
	public AddressEntity find(Long id) {
		return addressRepository.findOneById(id).orElseThrow(() -> Exception.ADDRESS_NOT_FOUND.raise());
	}

	@Override
	@Transactional
	public AddressEntity create(AddressEntity entity) {
		return addressRepository.save(entity);
	}

	@Override
	@Transactional
	public AddressEntity update(Long id, AddressEntity entity) {
		AddressEntity currentEntity = addressRepository.findOneById(id).orElseThrow(() -> Exception.ADDRESS_NOT_FOUND.raise());
		currentEntity.load(entity);
		return addressRepository.save(currentEntity);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		addressRepository.deleteOneById(id).orElseThrow(() -> Exception.USER_NOT_FOUND.raise());
	}

}
