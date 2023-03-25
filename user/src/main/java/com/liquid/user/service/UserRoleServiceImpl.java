package com.liquid.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liquid.user.entity.UserEntity;
import com.liquid.user.entity.UserRoleEntity;
import com.liquid.user.repository.UserRepository;
import com.liquid.user.repository.UserRoleRepository;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserRoleEntity find(Long id) {
		Optional<UserRoleEntity> address = userRoleRepository.findOneById(id);
		return address.get();
	}

	@Override
	public List<UserRoleEntity> list() {
		return userRoleRepository.findAll();
	}

	@Override
	public UserRoleEntity create(Long userId, UserRoleEntity entity) {
		entity.setUser(userRepository.findOneById(userId).orElse(new UserEntity()));
		return userRoleRepository.save(entity);
	}

	@Override
	public UserRoleEntity update(Long id, UserRoleEntity entity) {
		return userRoleRepository.save(entity);
	}

	@Override
	public UserRoleEntity delete(Long id) {
		return userRoleRepository.deleteOneById(id).get();
	}

}
