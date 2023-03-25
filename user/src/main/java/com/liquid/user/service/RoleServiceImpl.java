package com.liquid.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liquid.user.entity.RoleEntity;
import com.liquid.user.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public RoleEntity find(Long id) {
		Optional<RoleEntity> role = roleRepository.findOneById(id);
		return role.get();
	}

	@Override
	public List<RoleEntity> list() {
		return roleRepository.findAll();
	}

	@Override
	public RoleEntity create(RoleEntity entity) {
		return roleRepository.save(entity);
	}

	@Override
	public RoleEntity update(Long id, RoleEntity entity) {
		return roleRepository.save(entity);
	}

	@Override
	public RoleEntity delete(Long id) {
		return roleRepository.deleteOneById(id).get();
	}

}
