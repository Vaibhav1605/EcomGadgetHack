package com.ecom.ecombackend;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.ecombackend.dao.CustomerDao;
import com.ecom.ecombackend.modclass.Customer;
import junit.framework.Assert;

public class Testing {
	AnnotationConfigApplicationContext context;
	CustomerDao customerDao;
	Customer customer;
	
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ecom.ecombackend");
		context.refresh();
		customerDao = (CustomerDao)context.getBean("customerDao");
		customer = new Customer();
	
	}
	
	@Test
	public void createTest()
	{
		customer.setcustId(101);
		customer.setfirstName("Vaibhav");
		customer.setlastName("Sangamkar");
		customer.setpassword("abcd123");
		customer.setconfrimPassword("abcd123");
		
		Assert.assertEquals("Customer Added.!",true, customerDao.addCustomer(customer));
		
	}

		
	@Test
	public void deleteTest()
	{
		customer.getfirstName();
		customer.setcustId(11);
		Assert.assertEquals("Customer Deleted.!",true, customerDao.deleteCustomer(customer));
		
	}
	
	@Test
	public void getTest()
	{
		customer = customerDao.getCustomer(2);
		Assert.assertNotNull(customer);
		
	}
	
	@Test
	public void updateTest() {
		
		  customer = customerDao.getCustomer(2);
		  customer.setfirstName("Vaibhav");
		  customer.setlastName("Strange");
		  
		  Assert.assertEquals("update successful",true,customerDao.updateCustomer(customer));
	}

	@Test
	public void test() {
		
		 
		List<Customer> customers = customerDao.retreiveAllCustomers();
		for (int i = 0; i < customers.size(); i++) {
			  Customer customer = (Customer) customers.get(i);
				System.out.println(customer.getcustId()+" "+customer.getfirstName()+" "+customer.getlastName());
			  }
}
}
