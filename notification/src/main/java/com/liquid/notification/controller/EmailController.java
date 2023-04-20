package com.liquid.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liquid.notification.dto.MailSenderDto;
import com.liquid.notification.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/send")
	public ResponseEntity<?> send(@RequestBody MailSenderDto dto) {
		emailService.send(dto.getTo(), dto.getSubject(), dto.getMessage());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
}
