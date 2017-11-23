package com.ecom.ecombackend.modclass;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int custId;

	@NotBlank(message = "First Name should not be Blank")
	@NotNull(message = "First Name should not be Empty")
	@Pattern(regexp = "[a-z,A-Z]{3,}", message = "It should contain only Alphabet")
	private String firstName;

	@NotBlank(message = "Last Name should not be Blank")
	@NotNull(message = "Last Name should not be Empty")
	@Pattern(regexp = "[a-z,A-Z]{3,}", message = "It should contain only Alphabet")
	private String lastName;

	@Email
	@NotNull(message = "Email should not be Epmty")
	private String email;

	@Pattern(regexp = "[0-9]{10}", message = "Must contain 10 digits")
	private String mobileNumber;

	@NotBlank(message = "Enter a Password")
	@NotNull(message = "Enter a Password")
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,})", message = "Password should contain atleast one Capital Letter,one Digit,one Special Charecter")
	private String password;

	@Transient
	private String confirmPassword;

	private boolean is_Active;
	private String role = "ROLE_CUSTOMER";
	@OneToOne(mappedBy = "customer")
	private Cart cart;

	@OneToMany(mappedBy = "customer")
	private List<Orders> orders;

	/*@OneToOne(mappedBy = "customer")
	private Address address;*/

	/*public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
*/
	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isIs_Active() {
		return is_Active;
	}

	public void setIs_Active(boolean is_Active) {
		this.is_Active = is_Active;
	}

}
