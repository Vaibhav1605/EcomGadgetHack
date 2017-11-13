package com.ecom.ecombackend.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ecom.ecombackend.dao.CartItemsDao;
import com.ecom.ecombackend.modclass.CartItems;

@Repository("cartItemsDao")
@Transactional

public class CartItemsDaoImpl implements CartItemsDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addCartItems(CartItems cartItems) {
		try {

			sessionFactory.getCurrentSession().persist(cartItems);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteCartItems(CartItems cartItems) {
		try {

			sessionFactory.getCurrentSession().delete(cartItems);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateCartItems(CartItems cartItems) {
		try {
			sessionFactory.getCurrentSession().update(cartItems);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public CartItemsDao getCartItems(Integer id) {
		try {
			return (CartItemsDao) sessionFactory.getCurrentSession().get(CartItems.class, id);
		} catch (Exception e) {
			return null;
		}
	}

}