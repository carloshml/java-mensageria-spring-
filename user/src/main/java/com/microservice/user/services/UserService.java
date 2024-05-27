package com.microservice.user.services;

import org.springframework.stereotype.Service;

import com.microservice.user.models.UserModel;
import com.microservice.user.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	 
	final UserRepository userRepository;
	
	public UserService(UserRepository userRepositor) {
		  this.userRepository = userRepositor;
	}

	
	@Transactional
	public UserModel save(UserModel user) {
		return userRepository.save(user);
	}

}
