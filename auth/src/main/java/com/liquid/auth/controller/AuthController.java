package com.liquid.auth.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liquid.auth.dto.AuthDto;
import com.liquid.auth.dto.CredentialDto;
import com.liquid.auth.service.AuthService;

@RestController
@RequestMapping("/")
public class AuthController {

	@Autowired
	private AuthService service;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody CredentialDto credential) {
		return new ResponseEntity<>(service.login(credential), HttpStatus.OK);
	}

	@PostMapping("/logout")
	public ResponseEntity<?> logout(@RequestBody AuthDto dto) {
		return new ResponseEntity<>(service.logout(dto), HttpStatus.OK);
	}
	
	@PostMapping("/introspect")
	public ResponseEntity<?> introspect(@RequestBody AuthDto dto) {
		return new ResponseEntity<>(service.introspect(dto), HttpStatus.OK);
	}
	
	@GetMapping("/admin")
	@RolesAllowed("ADMIN")
	public ResponseEntity<?> admin() {
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/standard_user")
	@RolesAllowed("STANDARD_USER")
	public ResponseEntity<?> standard_user() {
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
