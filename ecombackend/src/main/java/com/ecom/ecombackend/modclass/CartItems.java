package com.ecom.ecombackend.modclass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class CartItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartItemsId;
	private double cartItemsPrice;
	private int cartItemsQuantity;
	@ManyToOne
	private Cart cart;
	@OneToOne
	private Product product;

	public int getCartItemsId() {
		return cartItemsId;
	}

	public void setCartItemsId(int cartItemsId) {
		this.cartItemsId = cartItemsId;
	}

	public double getCartItemsPrice() {
		return cartItemsPrice;
	}

	public void setCartItemsPrice(double cartItemsPrice) {
		this.cartItemsPrice = cartItemsPrice;
	}

	public int getCartItemsQuantity() {
		return cartItemsQuantity;
	}

	public void setCartItemsQuantity(int cartItemsQuantity) {
		this.cartItemsQuantity = cartItemsQuantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
