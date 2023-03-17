package com.liquid.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liquid.user.entity.UserEntity;
import com.liquid.user.entity.UserPasswordEntity;
import com.liquid.user.repository.UserPasswordRepository;
import com.liquid.user.repository.UserRepository;

@Service
public class UserPasswordServiceImpl implements UserPasswordService {

	@Autowired
	private UserPasswordRepository userPasswordRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserPasswordEntity find(Long id) {
		Optional<UserPasswordEntity> password = userPasswordRepository.findOneById(id);
		return password.get();
	}

	@Override
	public List<UserPasswordEntity> list() {
		return userPasswordRepository.findAll();
	}

	@Override
	public UserPasswordEntity create(Long userId, UserPasswordEntity password) {
		password.setUser(userRepository.findOneById(userId).orElse(new UserEntity()));
		return userPasswordRepository.save(password);
	}

	@Override
	public UserPasswordEntity update(Long id, UserPasswordEntity password) {
		return userPasswordRepository.save(password);
	}

	@Override
	public UserPasswordEntity delete(Long id) {
		return userPasswordRepository.deleteOneById(id).get();
	}
}
