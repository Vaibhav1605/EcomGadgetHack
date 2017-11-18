package com.ecom.ecombackend.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.ecombackend.dao.OrdersDao;
import com.ecom.ecombackend.modclass.Orders;



	
	@Repository("ordersDao")
	@Transactional
	public class OrdersDaoImpl implements OrdersDao {

		@Autowired
		SessionFactory sessionFactory;
		
		@Override
		public boolean placeOrders(Orders orders) {
			
				try {

					sessionFactory.getCurrentSession().persist(orders);
					return true;

				} catch (Exception e) {
					return false;
				}
		}

		@Override
		public boolean cancelOrders(Orders orders) {

			try {

				sessionFactory.getCurrentSession().delete(orders);
				return true;

			} catch (Exception e) {
			return false;
			}
		}
		
		@Override
		public Orders getOrders(int id) {
			try {
				return sessionFactory.getCurrentSession().get(Orders.class, id);
			} catch (Exception e) {
				return null;
			}
		}

}
