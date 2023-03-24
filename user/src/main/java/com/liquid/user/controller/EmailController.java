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

import com.liquid.user.dto.EmailDto;
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

	@GetMapping("/list")
	public ResponseEntity<?> list() {
		List<UserEmailEntity> entityList = service.list();
		return new ResponseEntity<>(emailMapper.toDto(entityList), HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Long id) {
		UserEmailEntity entity = service.find(id);
		return new ResponseEntity<>(emailMapper.toDto(entity), HttpStatus.OK);
	}

	@PostMapping("/create/{userId}")
	public ResponseEntity<?> addEmail(@PathVariable("userId") Long userId, @RequestBody EmailDto email) {
		UserEmailEntity entity = service.create(userId, emailMapper.toEntity(email));
		return new ResponseEntity<>(emailMapper.toDto(entity), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody EmailDto email) {
		UserEmailEntity entity = service.update(id, emailMapper.toEntity(email));
		return new ResponseEntity<>(emailMapper.toDto(entity), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		UserEmailEntity entity = service.delete(id);
		return new ResponseEntity<>(emailMapper.toDto(entity), HttpStatus.OK);
	}

}
