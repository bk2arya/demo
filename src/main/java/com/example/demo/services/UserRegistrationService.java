package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.UserRegistration;
import com.example.demo.repos.UserRegistrationRepo;

@Service
public class UserRegistrationService {

	@Autowired
	UserRegistrationRepo userService;
	
	public void saveUser(UserRegistration userObject) throws Exception{

			if(userObject!=null)
				userService.save(userObject);
			else 
				throw new Exception("User Object is null");
		
	}
	
	public UserRegistration findUser(int id) {
		
		return userService.findOne(id);
	}
	
	
	
}
