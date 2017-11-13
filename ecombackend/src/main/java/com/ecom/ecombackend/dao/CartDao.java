package com.ecom.ecombackend.dao;

import org.springframework.stereotype.Component;

import com.ecom.ecombackend.modclass.Cart;

@Component
public interface CartDao {

		boolean addCart(Cart cart);

		boolean deleteCart(Cart cart);

		boolean updateCart(Cart cart);

		Cart getCart(Integer id);

}
