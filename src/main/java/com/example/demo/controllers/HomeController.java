package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.Constant;
import com.example.demo.common.RatesDto;
import com.example.demo.entities.Employees;
import com.example.demo.entities.Rates;
import com.example.demo.services.EmployeesServiceImpl;
import com.example.demo.services.RatesImpl;
import com.google.gson.Gson;

@RestController
public class HomeController {

	@Autowired
	EmployeesServiceImpl empServiceImpl;
	
	@Autowired
	RatesImpl ratesImpl;
	
	/*@Autowired
	HospitalRepo hospital;
	
	@RequestMapping(value = "/hospitals", method = RequestMethod.GET)
	public List<Hospital> getHospitals() {
		
		List<Hospital> list = hospital.findAll();
		
		return list;
	}*/
	
	@RequestMapping("/hello")
	public String hello(@RequestParam(value="name", defaultValue="World..!!") String name) {
		return String.format(Constant.HELLO_TEMPLATE,name);
	}
	
	//THIS SYNTAX WORKS...!!!
	@RequestMapping("/login/{uname}&{pwd}")
	public String login(@PathVariable String uname,@PathVariable String pwd) {
		String message = "Hello %s,";
		String message2 = " your pwd is %s !";
		return String.format(message,uname)+String.format(message2,pwd);
	}
	
	@RequestMapping("/info/{name}:{uname}:{pwd}")
	public String displayInfo(@PathVariable String name, @PathVariable String uname, @PathVariable String pwd) {
		return "{\"name\": \""+name+"\",\"uname\" : \""+uname+"\",\"pwd\": \""+pwd+"\"}";
	}
	
	@RequestMapping("/employees")
	public List<Employees> getEmployees() {
	
	try {
		
		System.out.println("Entered \n");
		
		//List<Employees> e1 = empServiceImpl.getAllEmployeesByName("karthik");
		
		System.out.println("Test passed");
	}
	catch(Exception ex) {
		ex.printStackTrace();
	}
	
	return empServiceImpl.getAllEmployees();
	}
	
	@RequestMapping(value = "/deleteEmp/{id}", method = RequestMethod.GET)
	public List<Employees> deleteStudent(@PathVariable int id) {
		
		try {
		empServiceImpl.deleteEmployee(id);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return empServiceImpl.getAllEmployees();
	}
	
	@RequestMapping(value = "/update/{id}:{name}:{age}", method = RequestMethod.GET)
	public Employees updateEmployee(@PathVariable int id,@PathVariable String name,@PathVariable int age) {
		
		Employees emp = empServiceImpl.getEmployeeById(id);
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
	}
	
	
	@RequestMapping("/rates")
	public String getTaxForIncome(@RequestParam(value="income") Double income) {
	
		double totalTaxesPaid = 0,effectiveTaxRate=0;
		RatesDto ratesDto = new RatesDto();
		
		if(income<=0) {
			ratesDto.setStatus("NA");
		}
		else {
		List<Rates> ratesList = ratesImpl.getAllRates();
		
		for(Rates rate: ratesList) {
			
			if(income-rate.getIncomeTo()==0) {
				totalTaxesPaid+= (rate.getIncomeTo()-rate.getIncomeFrom())*rate.getTaxPercentage();
				break;
			}
			else if(income-rate.getIncomeTo()>0) {
				totalTaxesPaid+= (rate.getIncomeTo()-rate.getIncomeFrom())*rate.getTaxPercentage();
			}
			else {
				totalTaxesPaid+= (income-rate.getIncomeFrom())*rate.getTaxPercentage();
				break;
			}
		}
		effectiveTaxRate = totalTaxesPaid/income;
		ratesDto.setEffectiveTaxRate(effectiveTaxRate);
		ratesDto.setIncome(income);
		ratesDto.setTotalTaxesPaid(totalTaxesPaid);
		ratesDto.setStatus("A");
		}
		
		Gson gson = new Gson();
		String response = gson.toJson(ratesDto);
		
		return response;
	}
	
	
	
	
	
}
