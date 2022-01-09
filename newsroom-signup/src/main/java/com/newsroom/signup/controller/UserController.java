package com.newsroom.signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newsroom.signup.model.SignupRequest;
import com.newsroom.signup.model.SignupResponse;
import com.newsroom.signup.service.SignupService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = {"localhost"})
@RestController
public class UserController {

	@Autowired
	private SignupService signupService;

	@GetMapping("signup")
	public SignupResponse signup(@RequestBody SignupRequest request) {

		log.info("Engine: Signup-Request{}", request);

		SignupResponse response = signupService.signup(request);

		log.info("Engine: Signup-Response{}", response);

		return response;

	}

}
