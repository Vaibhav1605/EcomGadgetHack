package com.ecom.ecomfrontend;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecom.ecombackend.dao.CartDao;
import com.ecom.ecombackend.dao.CartItemsDao;
import com.ecom.ecombackend.dao.CustomerDao;
import com.ecom.ecombackend.dao.ProductDao;
import com.ecom.ecombackend.modclass.Cart;
import com.ecom.ecombackend.modclass.CartItems;
import com.ecom.ecombackend.modclass.Customer;
import com.ecom.ecombackend.modclass.Product;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private static final String Quantity = null;

	@Autowired
	ProductDao productDao;

	@Autowired
	CustomerDao customerDao;

	@Autowired
	CartItemsDao cartItemsDao;

	@Autowired
	CartDao cartDao;
	
	
	@RequestMapping("/addtocart/{productId}")
	public String addtoCart(@PathVariable("productId") int proId,Principal principal,ModelMap m)
	{
Product product = productDao.getProduct(proId);
		
		Customer customer = customerDao.getCustomerDetails(principal.getName());
		Cart cart = customer.getCart();
		CartItems cartItems = new CartItems();
		cartItems.setProduct(product);
		cartItems.setCartItemsQuantity(1);
		cartItems.setCart(cart);
		cartItems.setCartItemsPrice(cartItems.getCartItemsQuantity() * product.getProductPrice());
		ArrayList<CartItems> itemsList=new ArrayList<CartItems>();
		itemsList.add(cartItems);
		cart.setCartQuantity(cart.getCartQuantity()+cartItems.getCartItemsQuantity());
		cart.setTotalPrice(cart.getTotalPrice()+cartItems.getCartItemsPrice());
		cart.setCartItems(itemsList);
		
		cartItemsDao.addCartItems(cartItems);
		cartDao.updateCart(cart);
		m.addAttribute("cartItems",itemsList);
		m.addAttribute(product);
		m.addAttribute(cart);
		return "redirect:/";
	}
	
	@RequestMapping("/myCart")
	public String myCart(Model m, Principal principal)
	{
		Customer customer=customerDao.getCustomerDetails(principal.getName());
		Cart cart = customer.getCart();
		List<CartItems> cartItems = cart.getCartItems();
		
		m.addAttribute("cartItems",cartItems);
		m.addAttribute(cart);
		return "MyCart";
	}
	
	}

