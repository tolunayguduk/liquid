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

import com.liquid.user.dto.UserEmailDto;
import com.liquid.user.entity.UserEmailEntity;
import com.liquid.user.mapper.EmailMapper;
import com.liquid.user.service.UserEmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private UserEmailService service;

	@Autowired
	private EmailMapper emailMapper;

	@PostMapping("/create/{userId}")
	public ResponseEntity<?> addEmail(@PathVariable("userId") Long userId, @RequestBody UserEmailDto email) {
		UserEmailEntity entity = service.create(userId, emailMapper.toEntity(email));
		return new ResponseEntity<>(emailMapper.toDto(entity), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody UserEmailDto email) {
		UserEmailEntity entity = service.update(id, emailMapper.toEntity(email));
		return new ResponseEntity<>(emailMapper.toDto(entity), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
