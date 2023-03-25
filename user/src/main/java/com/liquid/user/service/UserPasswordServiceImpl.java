package com.liquid.user.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liquid.user.entity.UserPasswordEntity;
import com.liquid.user.repository.UserPasswordRepository;
import com.liquid.user.repository.UserRepository;
import com.liquid.util.exception.Exception;

@Service
public class UserPasswordServiceImpl implements UserPasswordService {

	@Autowired
	private UserPasswordRepository userPasswordRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public UserPasswordEntity create(Long userId, UserPasswordEntity entity) {
		entity.setUser(userRepository.findOneById(userId).orElseThrow(() -> Exception.USER_NOT_FOUND.raise()));
		return userPasswordRepository.save(entity);
	}

	@Override
	@Transactional
	public UserPasswordEntity update(Long id, UserPasswordEntity entity) {
		UserPasswordEntity currentEntity = userPasswordRepository.findOneById(id).orElseThrow(() -> Exception.PASSWORD_NOT_FOUND.raise());
		currentEntity.load(entity);
		return userPasswordRepository.save(currentEntity);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		userPasswordRepository.deleteOneById(id).orElseThrow(() -> Exception.PASSWORD_NOT_FOUND.raise());
	}
}
