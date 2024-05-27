package com.microservice.user.services;

import org.springframework.stereotype.Service;

import com.microservice.user.models.UserModel;
import com.microservice.user.producers.UserProducer;
import com.microservice.user.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	final UserRepository userRepository;
	final UserProducer userProducer;

	public UserService(UserRepository userRepositor, UserProducer userProducer) {
		this.userRepository = userRepositor;
		this.userProducer = userProducer;
	}

	@Transactional
	public UserModel save(UserModel user) {
		var userSaved = userRepository.save(user);
		userProducer.publishMensageEmail(user);
		return userSaved;
	}

}
