package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "california_address",schema="dbo")
public class Address implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer addressId;
	private String employeeAddress;

	private Set<UserRegistration> userReg;
	

	@Id 
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "userAddress") //user address here is the field inside "UserRegistration" Entity class
	public Set<UserRegistration> getUser() {
		return userReg;
	}
	public void setUser(Set<UserRegistration> userReg) {
		this.userReg = userReg;
	}
	
	public Address() {
		
	}
	
	public Address(Integer addressId, String employeeAddress, Set<UserRegistration> userReg) {
		super();
		this.addressId = addressId;
		this.employeeAddress = employeeAddress;
		this.userReg = userReg;
	}
	
	public Address(String employeeAddress) {
		super();
		this.employeeAddress = employeeAddress;
	}

	
	

}
