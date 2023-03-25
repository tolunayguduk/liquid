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

import com.liquid.user.dto.UserAddressDto;
import com.liquid.user.entity.UserAddressEntity;
import com.liquid.user.mapper.AddressMapper;
import com.liquid.user.service.UserAddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private UserAddressService service;

	@Autowired
	private AddressMapper addressMapper;

	@PostMapping("/create/{id}")
	public ResponseEntity<?> create(@PathVariable("id") Long userId, @RequestBody UserAddressDto address) {
		UserAddressEntity entity = service.create(userId, addressMapper.toEntity(address));
		return new ResponseEntity<>(addressMapper.toDto(entity), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody UserAddressDto address) {
		UserAddressEntity entity = service.update(id, addressMapper.toEntity(address));
		return new ResponseEntity<>(addressMapper.toDto(entity), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		UserAddressEntity entity = service.delete(id);
		return new ResponseEntity<>(addressMapper.toDto(entity), HttpStatus.OK);
	}

}
