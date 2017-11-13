package com.ecom.ecomfrontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecom.ecombackend.dao.CartDao;
import com.ecom.ecombackend.dao.CartItemsDao;
import com.ecom.ecombackend.dao.CustomerDao;
import com.ecom.ecombackend.dao.ProductDao;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	ProductDao productDao;

	@Autowired
	CustomerDao customerDao;

	@Autowired
	CartItemsDao cartItemsDao;

	@Autowired
	CartDao cartDao;

}
