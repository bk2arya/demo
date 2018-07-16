package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Address;


public interface AddressRepo extends CrudRepository<Address, Integer>{

	//public Employees getAllEmployeesName(String employeeName); 
}
