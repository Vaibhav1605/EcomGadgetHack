package com.ecom.ecombackend.dao;

import org.springframework.stereotype.Component;

import com.ecom.ecombackend.modclass.CartItems;

@Component
public interface CartItemsDao {
	
	boolean addCartItems(CartItems cartItems);

	boolean deleteCartItems(CartItems cartItems);

	boolean updateCartItems(CartItems cartItems);

	CartItemsDao getCartItems(Integer id);

}
