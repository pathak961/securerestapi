package com.hiringgo.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiringgo.assignment.entity.Users;
import com.hiringgo.assignment.repository.UsersRepository;

@Configuration
@RestController
@RequestMapping("/api")
public class RestControllers {

	@Autowired
	private UsersRepository userRepository;

	@PostMapping("/signup")
	public ResponseEntity<String> signUpUser(@RequestBody Users user) {

		if (userRepository.findByEmail(user.getEmail()).isPresent()) {
			return new ResponseEntity<>("Sign Up Failed, Email already exists", HttpStatus.BAD_REQUEST);
		}
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		userRepository.save(user);
		return ResponseEntity.ok("User Signed up Successfully");
	}

	@GetMapping("/test")
	public String test() {

		return "testing";
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
		return builder.getAuthenticationManager();
	}
}
