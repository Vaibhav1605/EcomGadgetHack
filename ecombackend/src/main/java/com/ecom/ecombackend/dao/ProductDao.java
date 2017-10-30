package com.ecom.ecombackend.dao;


import java.util.List;

import org.springframework.stereotype.Component;

import com.ecom.ecombackend.modclass.Product;



@Component
public interface ProductDao {

	boolean addProduct(Product product);
	boolean deleteProduct(Product product);
	boolean updateProduct(Product product);
	
	Product getProduct(Integer id);
	List<Product> retreiveAllProducts();
	
}
