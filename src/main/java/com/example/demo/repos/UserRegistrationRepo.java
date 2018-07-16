package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.UserRegistration;

public interface UserRegistrationRepo extends CrudRepository<UserRegistration, Integer>{

}
