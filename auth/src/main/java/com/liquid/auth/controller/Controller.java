package com.liquid.auth.controller;

import com.liquid.auth.dto.CredentialDto;
import com.liquid.auth.dto.TokenDto;
import com.liquid.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
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
    
    @PostMapping("/introspect")
    public ResponseEntity<?> introspect(@AuthenticationPrincipal Jwt jwt) {
        return new ResponseEntity<>(service.introspect(jwt), HttpStatus.OK);
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody TokenDto token) {
        return new ResponseEntity<>(service.refresh(token), HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody TokenDto token) {
        return new ResponseEntity<>(service.logout(token), HttpStatus.OK);
    }
}