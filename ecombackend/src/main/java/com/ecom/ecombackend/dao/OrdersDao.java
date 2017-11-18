package com.ecom.ecombackend.dao;

import org.springframework.stereotype.Component;

import com.ecom.ecombackend.modclass.Orders;

@Component
public interface OrdersDao {

	boolean placeOrders(Orders orders);

	boolean cancelOrders(Orders orders);

	Orders getOrders(int id);

}
