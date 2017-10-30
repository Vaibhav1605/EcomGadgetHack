package com.ecom.ecombackend.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.ecombackend.modclass.Product;
import com.ecom.ecombackend.dao.ProductDao;


@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addProduct(Product product) {

		try {
			
			sessionFactory.getCurrentSession().save(product);
			return true;
			
		}
		catch(Exception e)
		{
		return false;
		}
		
	}

	@Override
	public boolean deleteProduct(Product product) {
		

		try {
			
			sessionFactory.getCurrentSession().delete(product);
			return true;
			
		}
		catch(Exception e)
		{
		return false;
		}
		
	}

	@Override
	public boolean updateProduct(Product product) {
		
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		}catch(Exception e) {
		return false;
		}
	}

	@Override
	public Product getProduct(Integer id) {
		
		try 
		{
			return sessionFactory.getCurrentSession().get(Product.class, id);
		}
		catch(Exception e)
		{
			return null;
		}
		
	}

	@Override
	public List<Product> retreiveAllProducts() {
		
		try {
		return sessionFactory.getCurrentSession().createQuery("from Product").getResultList();
		}
		catch (HibernateException e) {
			e.printStackTrace();
			return null;
			
		}
	}

}
