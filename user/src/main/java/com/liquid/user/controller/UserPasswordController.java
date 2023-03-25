package com.liquid.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liquid.user.dto.UserPasswordDto;
import com.liquid.user.entity.UserPasswordEntity;
import com.liquid.user.mapper.PasswordMapper;
import com.liquid.user.service.UserPasswordService;

@RestController
@RequestMapping("/password")
public class UserPasswordController {

	@Autowired
	private UserPasswordService service;

	@Autowired
	private PasswordMapper passwordMapper;

	@PostMapping("/create/{userId}")
	public ResponseEntity<?> create(@PathVariable("userId") Long userId, @RequestBody UserPasswordDto dto) {
		service.create(userId, passwordMapper.toEntity(dto));
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody UserPasswordDto dto) {
		UserPasswordEntity entity = service.update(id, passwordMapper.toEntity(dto));
		return new ResponseEntity<>(passwordMapper.toDto(entity), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
