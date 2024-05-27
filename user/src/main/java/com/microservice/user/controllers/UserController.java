package com.microservice.user.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.user.dtos.UserRecordDTO;
import com.microservice.user.models.UserModel;
import com.microservice.user.services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/user")
	public ResponseEntity<UserModel> save(@RequestBody @Valid UserRecordDTO entity) {
		// TODO: process POST request
		var userModel = new UserModel();
		BeanUtils.copyProperties(entity, userModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
	}

}
