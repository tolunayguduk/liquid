package com.liquid.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liquid.notification.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@GetMapping("/")
	public ResponseEntity<?> send1() {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/send")
	public ResponseEntity<?> send() {
		emailService.send();
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
}
