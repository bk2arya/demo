package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Employees;
import com.example.demo.repos.EmployeesRepo;

@Service
public class EmployeesServiceImpl {

	@Autowired
	EmployeesRepo empRepo;

/*	
	public List<Employees> getAllEmployeesByName(String empName) {
		return (List<Employees>) empRepo.getAllEmployeesName(empName); 
	}*/
	
	public List<Employees> getAllEmployees() {
		return (List<Employees>) empRepo.findAll(); 
	}
	
	public Employees getEmployeeById(int id) {
		return (Employees) empRepo.findOne(id); 
	}
	
	public void save(Employees emp) {
		 empRepo.save(emp);
	}
	
	public void deleteEmployee(int id) {
		try {
		 empRepo.delete(id);
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
}
