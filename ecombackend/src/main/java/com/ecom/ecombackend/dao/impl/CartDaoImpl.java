package com.ecom.ecombackend.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.ecombackend.dao.CartDao;
import com.ecom.ecombackend.modclass.Cart;




@Repository("cartDao")
@Transactional
public class CartDaoImpl implements CartDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addCart(Cart cart) {
		
			try {

				sessionFactory.getCurrentSession().persist(cart);
				return true;

			} catch (Exception e) {
				return false;
			}
	}

	@Override
	public boolean deleteCart(Cart cart) {

		try {

			sessionFactory.getCurrentSession().delete(cart);
			return true;

		} catch (Exception e) {
		return false;
		}
	}
		

	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Cart getCart(Integer id) {
		try {
			return sessionFactory.getCurrentSession().get(Cart.class, id);
		} catch (Exception e) {
			return null;
		}
	}

	
}
