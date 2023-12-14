package com.liquid.auth.controller;

import com.liquid.auth.dto.CredentialDto;
import com.liquid.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class Controller {

    @Autowired
    private AuthService service;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody CredentialDto credential) {
        return new ResponseEntity<>(service.login(credential.getUsername(), credential.getPassword()), HttpStatus.OK);
    }

    @PostMapping("/logout/{refresh_token}")
    public ResponseEntity<?> logout(@PathVariable("refresh_token") String refresh_token) {
        return new ResponseEntity<>(service.logout(refresh_token), HttpStatus.OK);
    }

    @PostMapping("/introspect/{access_token}")
    public ResponseEntity<?> introspect(@PathVariable("access_token") String access_token) {
        return new ResponseEntity<>(service.introspect(access_token), HttpStatus.OK);
    }
}