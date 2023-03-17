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

import com.liquid.user.dto.PasswordDto;
import com.liquid.user.entity.UserPasswordEntity;
import com.liquid.user.mapper.PasswordMapper;
import com.liquid.user.service.UserPasswordService;
import com.liquid.util.model.BaseResponse;

@RestController
@RequestMapping("/password")
public class PasswordController {

	@Autowired
	private UserPasswordService service;

	@Autowired
	private PasswordMapper passwordMapper;

	@GetMapping("/list")
	public ResponseEntity<?> list() {
		List<UserPasswordEntity> entityList = service.list();
		return new ResponseEntity<>(new BaseResponse<>(passwordMapper.toDto(entityList)), HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Long id) {
		UserPasswordEntity entity = service.find(id);
		return new ResponseEntity<>(new BaseResponse<>(passwordMapper.toDto(entity)), HttpStatus.OK);
	}

	@PostMapping("/create/{userId}")
	public ResponseEntity<?> addEmail(@PathVariable("userId") Long userId, @RequestBody PasswordDto password) {
		UserPasswordEntity entity = service.create(userId, passwordMapper.toEntity(password));
		return new ResponseEntity<>(new BaseResponse<>(passwordMapper.toDto(entity)), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody PasswordDto password) {
		UserPasswordEntity entity = service.update(id, passwordMapper.toEntity(password));
		return new ResponseEntity<>(new BaseResponse<>(passwordMapper.toDto(entity)), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		UserPasswordEntity entity = service.delete(id);
		return new ResponseEntity<>(new BaseResponse<>(passwordMapper.toDto(entity)), HttpStatus.OK);
	}

}
