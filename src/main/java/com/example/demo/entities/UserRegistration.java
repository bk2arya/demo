package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "registered_users",schema="dbo")
public class UserRegistration implements Serializable{

	private static final long serialVersionUID = 1L;


private Integer userId;
private String firstName;
private String middleName;
private String lastName;
private String contactNo;
private String emailId;

private String username;
private String password;

private Set<Address> userAddress;

/*@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)*/


@Id 
@GeneratedValue(strategy= GenerationType.IDENTITY) //@GeneratedValue (strategy= GenerationType.AUTO)		
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getMiddleName() {
	return middleName;
}
public void setMiddleName(String middleName) {
	this.middleName = middleName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getContactNo() {
	return contactNo;
}
public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}

@ManyToMany(fetch = FetchType.LAZY,
cascade = {
    CascadeType.PERSIST,
    CascadeType.MERGE
})
@JoinTable(name = "user_address", 
joinColumns = { @JoinColumn(name = "userId") },
inverseJoinColumns = { @JoinColumn(name = "addressId") })
public Set<Address> getUserAddress() {
	return userAddress;
}
public void setUserAddress(Set<Address> userAddress) {
	this.userAddress = userAddress;
}

/*public List<Address> getEmployeeAddresslist() {
    return empAddressList;
  }

 public void setEmployeeAddresslist(List<Address> employeelist) {
    this.empAddressList = employeelist;
 }*/

/*public List<Address> getAddressSet() {
    return addressSet;
 }
 
 public void setAddressSet(List<Address> addressSet) {
    this.addressSet = addressSet;
 }
*/
	
}
