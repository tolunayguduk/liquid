package com.liquid.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liquid.user.entity.UserEmailEntity;
import com.liquid.user.repository.UserEmailRepository;
import com.liquid.user.repository.UserRepository;
import com.liquid.util.exception.CustomException;
import com.liquid.util.exception.Exception;

@Service
public class UserEmailServiceImpl implements UserEmailService {

	@Autowired
	private UserEmailRepository userEmailRepository;

	@Autowired
	private UserRepository userRepository;



	@Override
	public List<UserEmailEntity> find(Long userId) throws CustomException {
		return userEmailRepository.findByUserId(userId).orElseThrow(() -> Exception.EMAIL_NOT_FOUND.raise());
	}
	
	@Override
	@Transactional
	public void create(Long userId, UserEmailEntity entity) {
		entity.setUser(userRepository.findOneById(userId).orElseThrow(() -> Exception.USER_NOT_FOUND.raise()));
		userEmailRepository.save(entity);
	}

	@Override
	@Transactional
	public void update(Long id, UserEmailEntity entity) {
		UserEmailEntity currentEntity = userEmailRepository.findOneById(id).orElseThrow(() -> Exception.EMAIL_NOT_FOUND.raise());
		currentEntity.load(entity);
		userEmailRepository.save(currentEntity);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		userEmailRepository.deleteOneById(id).orElseThrow(() -> Exception.EMAIL_NOT_FOUND.raise());;
	}

}
