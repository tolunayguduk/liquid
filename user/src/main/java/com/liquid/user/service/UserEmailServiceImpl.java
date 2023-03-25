package com.liquid.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liquid.user.entity.UserEmailEntity;
import com.liquid.user.repository.UserEmailRepository;
import com.liquid.user.repository.UserRepository;
import com.liquid.util.exception.Exception;

@Service
public class UserEmailServiceImpl implements UserEmailService {

	@Autowired
	private UserEmailRepository userEmailRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public UserEmailEntity create(Long userId, UserEmailEntity entity) {
		entity.setUser(userRepository.findOneById(userId).orElseThrow(() -> Exception.USER_NOT_FOUND.raise()));
		return userEmailRepository.save(entity);
	}

	@Override
	@Transactional
	public UserEmailEntity update(Long id, UserEmailEntity entity) {
		UserEmailEntity currentEntity = userEmailRepository.findOneById(id).orElseThrow(() -> Exception.EMAIL_NOT_FOUND.raise());
		currentEntity.load(entity);
		return userEmailRepository.save(currentEntity);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		userEmailRepository.deleteOneById(id).orElseThrow(() -> Exception.EMAIL_NOT_FOUND.raise());;
	}

}
