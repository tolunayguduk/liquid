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

import com.liquid.user.dto.UserDto;
import com.liquid.user.entity.UserEntity;
import com.liquid.user.mapper.UserMapper;
import com.liquid.user.service.UserService;
import com.liquid.util.model.BaseResponse;

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private UserMapper userMapper;

	@GetMapping("/list")
	public ResponseEntity<?> list() {
		List<UserEntity> entityList = service.list();
		return new ResponseEntity<>(new BaseResponse<>(userMapper.toDto(entityList)), HttpStatus.OK);
	}

	@GetMapping("/find/id/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Long id) {
		UserEntity entity = service.find(id);
		return new ResponseEntity<>(new BaseResponse<>(userMapper.toDto(entity)), HttpStatus.OK);
	}
	
	@GetMapping("/find/username/{username}")
	public ResponseEntity<?> find(@PathVariable("username") String username) {
		UserEntity entity = service.find(username);
		return new ResponseEntity<>(new BaseResponse<>(userMapper.toDto(entity)), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody UserDto user) {
		UserEntity entity = service.create(userMapper.toEntity(user));
		return new ResponseEntity<>(new BaseResponse<>(userMapper.toDto(entity)), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody UserDto user) {
		UserEntity entity = service.update(id, userMapper.toEntity(user));
		return new ResponseEntity<>(new BaseResponse<>(userMapper.toDto(entity)), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		UserEntity entity = service.delete(id);
		return new ResponseEntity<>(new BaseResponse<>(userMapper.toDto(entity)), HttpStatus.OK);
	}

}
