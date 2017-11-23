package com.ecom.ecombackend.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import com.ecom.ecombackend.modclass.Customer;

@Component
public interface CustomerDao {
	
	public boolean deleteCustomer(Customer customer);

	//public boolean getCustomer(Customer customer);

	public boolean addCustomer(Customer customer);
	
	

	public Customer getCustomer(int id);

	Customer getCustomerDetails(String name);

	public boolean updateCustomer(Customer customer);

	List<Customer> retreiveAllCustomers();

}
