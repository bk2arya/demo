package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Employees;

public interface EmployeesRepo extends CrudRepository<Employees, Integer>{

	//public Employees getAllEmployeesName(String employeeName); 
}
