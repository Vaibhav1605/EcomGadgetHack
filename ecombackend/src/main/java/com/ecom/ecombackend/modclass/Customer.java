package com.ecom.ecombackend.modclass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int custId;
	private String firstName;
	private String lastName;
	private String password;
	@Transient
	private String confirmPassword;
	public int getcustId() {
		return custId;
	}
	public void setcustId(int custId) {
		this.custId = custId;
	}

	public String getfirstName() {
		return firstName;
	}
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getlastName() {
		return lastName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public String getconfirmPassword() {
		return confirmPassword;
	}
	public void setconfrimPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
