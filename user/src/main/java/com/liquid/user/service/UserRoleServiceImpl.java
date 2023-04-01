package com.liquid.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liquid.user.entity.RoleEntity;
import com.liquid.user.entity.UserRoleEntity;
import com.liquid.user.repository.RoleRepository;
import com.liquid.user.repository.UserRepository;
import com.liquid.user.repository.UserRoleRepository;
import com.liquid.util.exception.CustomException;
import com.liquid.util.exception.Exception;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;
	

	@Override
	public List<RoleEntity> find(Long userId) throws CustomException {
		List<UserRoleEntity> userRoles = userRoleRepository.findByUserId(userId).orElseThrow(() -> Exception.ROLE_NOT_FOUND.raise());
		return userRoles.stream().map(UserRoleEntity::getRole).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void create(Long userId, RoleEntity entity) {
		UserRoleEntity userRoleEntity = new UserRoleEntity();
		RoleEntity role = roleRepository.save(entity);
		
		userRoleEntity.setUser(userRepository.findOneById(userId).orElseThrow(() -> Exception.USER_NOT_FOUND.raise()));
		userRoleEntity.setRole(role);
		
		userRoleRepository.save(userRoleEntity);
	}

	@Override
	@Transactional
	public void update(Long userId, Long roleId, RoleEntity entity) {
		UserRoleEntity currentEntity = userRoleRepository.findOneByUserIdAndRoleId(userId, roleId).orElseThrow(() -> Exception.ROLE_NOT_FOUND.raise());
		currentEntity.getRole().load(entity);
		userRoleRepository.save(currentEntity);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		userRoleRepository.deleteOneById(id).get();
	}

}
