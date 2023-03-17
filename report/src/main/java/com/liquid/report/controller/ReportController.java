package com.liquid.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liquid.report.service.UserService;
import com.liquid.util.model.BaseResponse;


@RestController
@RequestMapping("/")
public class ReportController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<?> list() {
		return new ResponseEntity<>(new BaseResponse<>(userService.find(1L)), HttpStatus.OK);
	}

}
