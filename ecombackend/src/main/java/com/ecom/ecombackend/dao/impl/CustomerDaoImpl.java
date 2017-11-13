package com.ecom.ecombackend.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.ecombackend.modclass.*;
import com.ecom.ecombackend.dao.CustomerDao;

@Repository("customerDao")
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addCustomer(Customer customer) {

		try {
			sessionFactory.getCurrentSession().persist(customer);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean deleteCustomer(Customer customer) {

		try {
			sessionFactory.getCurrentSession().delete(customer);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public Customer getCustomer(int id) {
		try {
			return sessionFactory.getCurrentSession().get(Customer.class, id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		try {

			sessionFactory.getCurrentSession().update(customer);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean getCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return true;
	}

	public List<Customer> retreiveAllCustomers() {

		try {

			return sessionFactory.getCurrentSession().createQuery("from Customer", Customer.class).getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;

		}

	}

	@Override
	public Customer getCustomerDetails(String name) {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Customer where email=:email", Customer.class)
					.setParameter("email", name).getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}
