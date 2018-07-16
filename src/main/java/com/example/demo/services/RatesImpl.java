package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Rates;
import com.example.demo.repos.RatesRepo;

@Service
public class RatesImpl {

	@Autowired
	RatesRepo ratesRepo;

/*	
	public List<Employees> getAllEmployeesByName(String empName) {
		return (List<Employees>) empRepo.getAllEmployeesName(empName); 
	}*/
	
	public List<Rates> getAllRates() {
		return (List<Rates>) ratesRepo.findAll(); 
	}
	
	public Rates getRateById(int id) {
		return ratesRepo.findOne(id); 
	}
	
	public void save(Rates rate) {
		ratesRepo.save(rate);
	}
	
	public void deleteRate(int id) {
		try {
			ratesRepo.delete(id);
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

	
}
