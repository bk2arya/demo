package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.Address;
import com.example.demo.entities.Employees;
import com.example.demo.entities.UserRegistration;
import com.example.demo.repos.AddressRepo;
import com.example.demo.services.UserRegistrationService;

@Controller
public class ViewController {

	@Autowired
	UserRegistrationService userService;
	
	@Autowired
	AddressRepo addressRepo;
	
	@RequestMapping("/reg")
	public String reg() {
	System.out.println("hello");
	return "userRegistrationForm";
	}
	
	/*@RequestMapping(value = "/updateAddress/{id}:{addId}", method = RequestMethod.GET)
	public Employees updateAddress(@PathVariable int id,@PathVariable int addId) {
		
		try {
			if(emp != null) {
				emp.setEmployeeName(name);
				emp.setEmployeeAge(age);
				empServiceImpl.save(emp);
			}
		
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		//return empServiceImpl.getAllEmployees();
		return empServiceImpl.getEmployeeById(id);
	}*/
	
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public ModelAndView userRegistration(@ModelAttribute UserRegistration userObject, ModelAndView model) {
	

		try {
			
			Set<Address> addressList = new HashSet<Address>(); //THIS WILL BE A SET OF ROLES IF USER HAS MULTIPLE ROLES, ELSE A SINGLE ROLE
																//IF NORMAL LOGIN, WILL CREATE A DEFAULT ROLE OBJECT
			Address address1 = addressRepo.findOne(11);				//this method works..!!			
			//address1.setEmployeeAddress("Mysore");				//AVOID THIS AND SET THE ROLE IN THE CONSTRUCTOR ONLY
			//Address address2 = new Address();`				//creating new Object actually insertsnew row in the address table
			//address1.setEmployeeAddress("Bangalore");
			addressList.add(address1);
			//addressList.add(address2);
			
			Set<UserRegistration> users = new HashSet<UserRegistration>();
			
			 /*Book bookA = new Book("Book A");

		        Publisher publisherA = new Publisher("Publisher A");

		        BookPublisher bookPublisher = new BookPublisher();
		        bookPublisher.setBook(bookA);
		        bookPublisher.setPublisher(publisherA);
		        bookPublisher.setPublishedDate(new Date());
		        bookA.getBookPublishers().add(bookPublisher);

		        publisherRepository.save(publisherA);
		        bookRepository.save(bookA);
			*/
			
			/*UserAddress uA = new UserAddress();
			uA.setUser(userObject);
			uA.setAddress(address1);
			userObject.getUserAddress().add(uA);
			
			addressRepo.save(address1);
			userService.saveUser(userObject);*/
			
			userObject.setUserAddress(addressList);//getUserAddress().add(address1);	//ONE WAY SETTING
			//userObject.getUserAddress().add(address2);
			users.add(userObject);														//SAVING TO USER-ROLE TABLE, UNIDIRECTIONAL
			//address1.setUser(users);/*getUser().add(userObject);						//SAVING TO USER-ROLE TABLE, BIDIRECTIONAL. COMPLETE
			//address2.getUser().add(userObject);*/
			
			userService.saveUser(userObject);
			model.setViewName("welcome");
			model.addObject("firstName", userObject.getFirstName());
			model.addObject("lastName", userService.findUser(2).getLastName());
			model.addObject("address", userService.findUser(8).getUserAddress());
			//model.addObject("address2", userObject.getFirstName());
		
	}
	catch(Exception ex) {
		ex.printStackTrace();
	}
	
	return model;
	}
	
	
}
