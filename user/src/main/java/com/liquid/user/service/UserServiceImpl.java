package com.liquid.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liquid.user.entity.UserEntity;
import com.liquid.user.repository.UserRepository;
import com.liquid.util.exception.CustomException;
import com.liquid.util.exception.Exception;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public List<UserEntity> list() {
		return userRepository.findAll();
	}
	
	@Override
	@Transactional
	public UserEntity find(Long id) {
		return userRepository.findOneById(id).orElseThrow(() -> Exception.USER_NOT_FOUND.raise());
	}

	@Override
	@Transactional
	public UserEntity find(String username) throws CustomException {
		return userRepository.findOneByUsername(username).orElseThrow(() -> Exception.USER_NOT_FOUND.raise());
	}

	@Override
	@Transactional
	public UserEntity create(UserEntity entity) {
		return userRepository.save(entity);
	}

	@Override
	@Transactional
	public UserEntity update(Long id, UserEntity entity) {
		UserEntity currentEntity = userRepository.findOneById(id).orElseThrow(() -> Exception.USER_NOT_FOUND.raise());
		currentEntity.load(entity);
		return userRepository.save(currentEntity);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		userRepository.deleteOneById(id).orElseThrow(() -> Exception.USER_NOT_FOUND.raise());
	}

}
