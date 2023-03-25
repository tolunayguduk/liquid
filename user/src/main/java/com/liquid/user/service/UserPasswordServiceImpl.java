package com.liquid.user.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public UserPasswordEntity create(Long userId, UserPasswordEntity password) {
		password.setUser(userRepository.findOneById(userId).orElseThrow(() -> Exception.USER_NOT_FOUND.raise()));
		return userPasswordRepository.save(password);
	}

	@Override
	@Transactional
	public UserPasswordEntity update(Long id, UserPasswordEntity userPassword) {
		UserPasswordEntity currentUserPassword = userPasswordRepository.findOneById(id).orElseThrow(() -> Exception.PASSWORD_NOT_FOUND.raise());
		currentUserPassword.load(userPassword);
		return userPasswordRepository.save(currentUserPassword);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		userPasswordRepository.deleteOneById(id).orElseThrow(() -> Exception.PASSWORD_NOT_FOUND.raise());
	}
}
