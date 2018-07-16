/*package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_address",schema="dbo")
public class UserAddress implements Serializable{

	*//**
	 * 
	 *//*
	private static final long serialVersionUID = 1L;
	
	
	private UserRegistration user;
	private Address address ;
	private Date datetime;

	@Id
	@ManyToOne
	@JoinColumn(name="userId")
	public UserRegistration getUser() {
		return user;
	}

	public void setUser(UserRegistration user) {
		this.user = user;
	}

	@Id
	@ManyToOne
	@JoinColumn(name="addressId")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
	
	
	

}
*/