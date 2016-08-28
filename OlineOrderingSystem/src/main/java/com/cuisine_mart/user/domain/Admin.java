package com.cuisine_mart.user.domain;

import javax.persistence.Entity;
/**
 * @author Sadiksha
 *
 */
@Entity
public class Admin extends Person {

	private String role;
	private String password;
	private boolean enabled;
	public Admin(){}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
