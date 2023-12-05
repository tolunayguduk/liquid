package com.liquid.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liquid.report.service.UserService;
import com.liquid.util.common.GeneralParameterService;
import com.liquid.util.common.SystemParameterService;

@RestController
@RequestMapping("/")
public class ReportController {

	@Autowired
	private UserService userService;

	@GetMapping("/hello")
	public ResponseEntity<?> hello() {
		return new ResponseEntity<>("hello", HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<?> list() {
		return new ResponseEntity<>(userService.find(1L), HttpStatus.OK);
	}

	@GetMapping("/system-param")
	public ResponseEntity<?> system() {
		return new ResponseEntity<>(SystemParameterService.get("JWT"), HttpStatus.OK);
	}
	
}
