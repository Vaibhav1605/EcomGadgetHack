package com.ecom.ecombackend.dao.impl;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.ecombackend.dao.AddressDao;
import com.ecom.ecombackend.modclass.Address;

@Repository("addressDao")
@Transactional
public class AddressDaoImpl implements AddressDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Address getAddress(int add_id) {
		try {
			return sessionFactory.getCurrentSession().get(Address.class, add_id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().save(address);
			return true;
		} catch (Exception ex) {
			return false;
		}

	}

	@Override
	public boolean deleteAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().delete(address);
			return true;
		} catch (Exception ex) {
			return false;
		}

	}

	@Override
	public boolean updateAddress(Address address) {
		try {

			sessionFactory.getCurrentSession().update(address);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Address getAddressOfCustomer(Integer id) {
		try{
			return sessionFactory.getCurrentSession().createQuery("From Address where CUSTOMER_CUSTID=:custid",Address.class)
			.setParameter("custid", id)
			.getSingleResult();
		}catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

}
