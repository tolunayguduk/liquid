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

import com.liquid.user.dto.UserEmailDto;
import com.liquid.user.entity.UserEmailEntity;
import com.liquid.user.mapper.UserEmailMapper;
import com.liquid.user.service.UserEmailService;

@RestController
@RequestMapping("/email")
public class UserEmailController {

	@Autowired
	private UserEmailService service;

	@Autowired
	private UserEmailMapper emailMapper;

	@GetMapping("/find/{userId}")
	public ResponseEntity<?> find(@PathVariable("userId") Long userId) {
		List<UserEmailEntity> entity = service.find(userId);
		return new ResponseEntity<>(emailMapper.toDto(entity), HttpStatus.OK);
	}
	
	@PostMapping("/create/{userId}")
	public ResponseEntity<?> addEmail(@PathVariable("userId") Long userId, @RequestBody UserEmailDto dto) {
		service.create(userId, emailMapper.toEntity(dto));
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/update/{userId}")
	public ResponseEntity<?> update(@PathVariable("userId") Long userId, @RequestBody UserEmailDto dto) {
		service.update(userId, emailMapper.toEntity(dto));
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
