package com.ecom.ecombackend;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.ecombackend.dao.CartDao;
import com.ecom.ecombackend.dao.CartItemsDao;
import com.ecom.ecombackend.dao.ProductDao;
import com.ecom.ecombackend.modclass.Cart;
import com.ecom.ecombackend.modclass.CartItems;
import com.ecom.ecombackend.modclass.Product;

public class CartItemsTest {
	private AnnotationConfigApplicationContext context;
	private CartItemsDao cartItemsDao;
	private CartDao cartDao;
	private ProductDao productDao;
	private Cart cart;
	private CartItems cartItems;
	private Product product;
	
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ecom");
		context.refresh();
		cartDao=(CartDao)context.getBean("cartDao");
		productDao=(ProductDao)context.getBean("productDao");
		cartItemsDao=(CartItemsDao)context.getBean("cartItemsDao");
		
	}
	
	@Test
	public void addCartItemsTest()
	{
		//get Product
		product=productDao.getProduct(1);
		//create cartItem
		cartItems=new CartItems();
		//set Product
		cartItems.setProduct(product);
		//set Quantity
		cartItems.setCartItemsQuantity(5);
		//set Price
		cartItems.setCartItemsPrice(product.getProductPrice()*cartItems.getCartItemsQuantity());
		//cart Object
		cart=cartDao.getCart(1);
		//set Cart
		cartItems.setCart(cart);
		
		//List Of CartItems
		ArrayList<CartItems> itemsList=new ArrayList<CartItems>();
		itemsList.add(cartItems);
		cart.setCartQuantity(cart.getCartQuantity()+cartItems.getCartItemsQuantity());
		cart.setTotalPrice(cart.getTotalPrice()+cartItems.getCartItemsPrice());
		cart.setCartItems(itemsList);
		
		Assert.assertEquals("adding of cartItems",true,cartItemsDao.addCartItems(cartItems));
		Assert.assertEquals("updating of Cart",true,cartDao.updateCart(cart));
		
		
	}
	

}
