package com.liquid.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liquid.user.dto.RoleDto;
import com.liquid.user.entity.RoleEntity;
import com.liquid.user.mapper.RoleMapper;
import com.liquid.user.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService service;

	@Autowired
	private RoleMapper roleMapper;

	@GetMapping("/list")
	public ResponseEntity<?> list() {
		List<RoleEntity> entityList = service.list();
		return new ResponseEntity<>(roleMapper.toDto(entityList), HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Long id) {
		RoleEntity entity = service.find(id);
		return new ResponseEntity<>(roleMapper.toDto(entity), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody RoleDto user) {
		RoleEntity entity = service.create(roleMapper.toEntity(user));
		return new ResponseEntity<>(roleMapper.toDto(entity), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody RoleDto role) {
		RoleEntity entity = service.update(id, roleMapper.toEntity(role));
		return new ResponseEntity<>(roleMapper.toDto(entity), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		RoleEntity entity = service.delete(id);
		return new ResponseEntity<>(roleMapper.toDto(entity), HttpStatus.OK);
	}
}
