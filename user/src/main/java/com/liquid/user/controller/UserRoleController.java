package com.liquid.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liquid.user.entity.RoleEntity;
import com.liquid.user.mapper.RoleMapper;
import com.liquid.user.service.UserRoleService;

@RestController
@RequestMapping("/user-role")
public class UserRoleController {

	@Autowired
	private UserRoleService service;

	@Autowired
	private RoleMapper roleMapper;
	
	@GetMapping("/find/{userId}")
	public ResponseEntity<?> find(@PathVariable("userId") Long userId) {
		List<RoleEntity> entity = service.find(userId);
		return new ResponseEntity<>(roleMapper.toDto(entity), HttpStatus.OK);
	}

	@PostMapping("/create/{userId}/{roleId}")
	public ResponseEntity<?> create(@PathVariable("userId") Long userId, @PathVariable("roleId") Long roleId) {
		service.create(userId, roleId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
