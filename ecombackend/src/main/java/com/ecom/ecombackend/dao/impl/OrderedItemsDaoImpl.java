package com.ecom.ecombackend.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.ecombackend.dao.OrderedItemsDao;
import com.ecom.ecombackend.modclass.OrderedItems;

@Repository("orderedItemsDao")
@Transactional
public class OrderedItemsDaoImpl implements OrderedItemsDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addOrderedItems(OrderedItems orderedItems) {
		try {

			sessionFactory.getCurrentSession().persist(orderedItems);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteOrderedItems(OrderedItems orderedItems) {
		try {

			sessionFactory.getCurrentSession().delete(orderedItems);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public OrderedItems getOrderedItems(int id) {
		try {
			return (OrderedItems) sessionFactory.getCurrentSession().get(OrderedItems.class, id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<OrderedItems> retrieveAllOrderedItems() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from OrderedItems", OrderedItems.class)
					.getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

}
