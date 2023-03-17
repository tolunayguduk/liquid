package com.liquid.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liquid.user.entity.UserEmailEntity;
import com.liquid.user.entity.UserEntity;
import com.liquid.user.repository.UserEmailRepository;
import com.liquid.user.repository.UserRepository;

@Service
public class UserEmailServiceImpl implements UserEmailService {

	@Autowired
	private UserEmailRepository userEmailRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEmailEntity find(Long id) {
		Optional<UserEmailEntity> email = userEmailRepository.findOneById(id);
		return email.get();
	}

	@Override
	public List<UserEmailEntity> list() {
		return userEmailRepository.findAll();
	}

	@Override
	public UserEmailEntity create(Long userId, UserEmailEntity email) {
		email.setUser(userRepository.findOneById(userId).orElse(new UserEntity()));
		return userEmailRepository.save(email);
	}

	@Override
	public UserEmailEntity update(Long id, UserEmailEntity email) {
		return userEmailRepository.save(email);
	}

	@Override
	public UserEmailEntity delete(Long id) {
		return userEmailRepository.deleteOneById(id).get();
	}

}
