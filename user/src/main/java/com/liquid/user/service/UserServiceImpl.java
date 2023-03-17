package com.liquid.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liquid.user.entity.UserEntity;
import com.liquid.user.repository.UserRepository;
import com.liquid.util.exception.CustomException;
import com.liquid.util.exception.Exception;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserEntity> list() {
		return userRepository.findAll();
	}
	
	@Override
	public UserEntity find(Long id) {
		return userRepository.findOneById(id).orElseThrow(() -> Exception.USER_NOT_FOUND.raise());
	}

	@Override
	public UserEntity find(String username) throws CustomException {
		return userRepository.findOneByUsername(username).orElseThrow(() -> Exception.USER_NOT_FOUND.raise());
	}

	@Override
	public UserEntity create(UserEntity user) {
		return userRepository.save(user);
	}

	@Override
	public UserEntity update(Long id, UserEntity user) {
		return userRepository.save(user);
	}

	@Override
	public UserEntity delete(Long id) {
		return userRepository.deleteOneById(id).orElseThrow(() -> Exception.USER_NOT_FOUND.raise());
	}

}
