package com.hiringgo.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiringgo.assignment.entity.RefreshTokenRequest;
import com.hiringgo.assignment.jwt.service.CustomUserDetailsService;
import com.hiringgo.assignment.jwt.util.JwtHelper;

@RestController
@RequestMapping("/api")
public class RefreshController {

	@Autowired
	private JwtHelper jwtHelper;

	@Autowired
	CustomUserDetailsService userDetailsService;

	@PostMapping("/refresh")
	public ResponseEntity<String> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
		String refreshedToken = jwtHelper
				.generateToken(userDetailsService.loadUserByUsername(refreshTokenRequest.getEmail()));
		return ResponseEntity.ok(refreshedToken);
	}
}
