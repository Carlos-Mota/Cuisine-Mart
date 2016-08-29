package com.cuisine_mart.user.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Sadiksha
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Person {
	@Id @GeneratedValue
	private int personId;
	private String fristName;
	private String lastName;
	private String email;
	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="addressId")
	private List<Address> address = new ArrayList<Address>();
	
	public Person(){}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	public String getFristName() {
		return fristName;
	}
	public void setFristName(String fristName) {
		this.fristName = fristName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
