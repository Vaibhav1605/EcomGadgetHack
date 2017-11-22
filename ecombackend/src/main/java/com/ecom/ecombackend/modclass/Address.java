package com.ecom.ecombackend.modclass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int add_Id;

	@NotBlank(message = "Enter your House No")
	private String add_Hno;
	private String add_Street;
	private String add_City;
	private String add_State;

	@NotBlank(message = "Enter Pincode")
	@Pattern(regexp = "[0-9]{,6}", message = "Enter your 6 digit Pincode")
	private String add_Pincode;

	@OneToOne()
	private Customer customer;

	public int getAdd_Id() {
		return add_Id;
	}

	public void setAdd_Id(int add_Id) {
		this.add_Id = add_Id;
	}

	public String getAdd_Hno() {
		return add_Hno;
	}

	public void setAdd_Hno(String add_Hno) {
		this.add_Hno = add_Hno;
	}

	public String getAdd_Street() {
		return add_Street;
	}

	public void setAdd_Street(String add_Street) {
		this.add_Street = add_Street;
	}

	public String getAdd_City() {
		return add_City;
	}

	public void setAdd_City(String add_City) {
		this.add_City = add_City;
	}

	public String getAdd_State() {
		return add_State;
	}

	public void setAdd_State(String add_State) {
		this.add_State = add_State;
	}

	public String getAdd_Pincode() {
		return add_Pincode;
	}

	public void setAdd_Pincode(String add_Pincode) {
		this.add_Pincode = add_Pincode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
