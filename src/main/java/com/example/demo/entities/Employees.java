package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "california_employees",schema="dbo")
public class Employees implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer employeeId;
	private String employeeName;
	private Integer employeeAge;
	
	
	
	@Id 
	//@Column(name="`employeeId`")
	@GeneratedValue (strategy= GenerationType.AUTO)		//strategy= GenerationType.IDENTITY for MS SQL SERVER
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	 
	//@Column(name="`employeeName`")
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	//@Column(name="`employeeAge`")
	public int getEmployeeAge() {
		return employeeAge;
	}
	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}
	
	
	
}
