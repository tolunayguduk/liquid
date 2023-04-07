package com.liquid.user.controller;

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
import com.liquid.user.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService service;

	@Autowired
	private AddressMapper addressMapper;

	@GetMapping("/find/{addressId}")
	public ResponseEntity<?> find(@PathVariable("addressId") Long addressId) {
		AddressEntity entity = service.find(addressId);
		return new ResponseEntity<>(addressMapper.toDto(entity), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody AddressDto dto) {
		AddressEntity entity = service.create(addressMapper.toEntity(dto));
		return new ResponseEntity<>(addressMapper.toDto(entity), HttpStatus.OK);
	}

	@PostMapping("/update/{addressId}")
	public ResponseEntity<?> update(@PathVariable("addressId") Long addressId, @RequestBody AddressDto dto) {
		AddressEntity entity = service.update(addressId, addressMapper.toEntity(dto));
		return new ResponseEntity<>(addressMapper.toDto(entity), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{addressId}")
	public ResponseEntity<?> delete(@PathVariable("addressId") Long addressId) {
		service.delete(addressId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
