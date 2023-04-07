package com.liquid.util.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liquid.util.common.SystemParameterService;

@RestController
@RequestMapping("/system-parameter")
public class SystemParameterController {

	@Autowired
	private SystemParameterService service;

	@GetMapping("/find/{key1}")
	public ResponseEntity<?> get(@PathVariable("key1") String key1) {
		return new ResponseEntity<>(service.get(key1), HttpStatus.OK);
	}

	@GetMapping("/find/{key1}/{key2}")
	public ResponseEntity<?> get(@PathVariable("key1") String key1, @PathVariable("key2") String key2) {
		return new ResponseEntity<>(service.get(key1, key2), HttpStatus.OK);
	}

	@GetMapping("/find/{key1}/{key2}/{key3}")
	public ResponseEntity<?> get(@PathVariable("key1") String key1, @PathVariable("key2") String key2, @PathVariable("key3") String key3) {
		return new ResponseEntity<>(service.get(key1, key2, key3), HttpStatus.OK);
	}

}
