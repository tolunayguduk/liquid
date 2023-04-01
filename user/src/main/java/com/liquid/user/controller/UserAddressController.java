package com.liquid.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liquid.user.dto.AddressDto;
import com.liquid.user.entity.AddressEntity;
import com.liquid.user.mapper.AddressMapper;
import com.liquid.user.service.UserAddressService;

@RestController
@RequestMapping("/user-address")
public class UserAddressController {

	@Autowired
	private UserAddressService service;

	@Autowired
	private AddressMapper addressMapper;
	
	@GetMapping("/find/{userId}")
	public ResponseEntity<?> find(@PathVariable("userId") Long userId) {
		List<AddressEntity> entity = service.find(userId);
		return new ResponseEntity<>(addressMapper.toDto(entity), HttpStatus.OK);
	}

	@PostMapping("/create/{userId}/{addressId}")
	public ResponseEntity<?> create(@PathVariable("userId") Long userId, @PathVariable("addressId") Long addressId) {
		service.create(userId, addressId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/create/{userId}")
	public ResponseEntity<?> create(@PathVariable("userId") Long userId, @RequestBody AddressDto dto) {
		service.create(userId, addressMapper.toEntity(dto));
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
