package com.microservice.user.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.user.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID> {

}
