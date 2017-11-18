package com.ecom.ecombackend.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ecom.ecombackend.modclass.OrderedItems;

@Component
public interface OrderedItemsDao {

	public boolean addOrderedItems(OrderedItems orderedItems);

	public boolean deleteOrderedItems(OrderedItems orderedItems);

	public OrderedItems getOrderedItems(int id);

	List<OrderedItems> retrieveAllOrderedItems();

}
