package com.liquid.auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AuthController {
	
    @GetMapping("/profile")
    public ResponseEntity<?> profile() {
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
}
