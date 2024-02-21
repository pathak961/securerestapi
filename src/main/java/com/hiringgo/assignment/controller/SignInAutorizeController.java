package com.hiringgo.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiringgo.assignment.entity.JwtRequest;
import com.hiringgo.assignment.entity.JwtResponse;
import com.hiringgo.assignment.jwt.util.JwtHelper;

@RestController
@RequestMapping("/api")
public class SignInAutorizeController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtHelper jwtHelper;

	@PostMapping("/signin")
	public ResponseEntity<?> signIn(@RequestBody JwtRequest jwtRequest) {
		try {
			// Authenticate the user
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword()));

			// Generate JWT token
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String token = jwtHelper.generateToken(userDetails);

			return ResponseEntity.ok(new JwtResponse(token));
		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
		}
	}
}
