package com.ecom.ecomfrontend;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecom.ecombackend.dao.AddressDao;
import com.ecom.ecombackend.dao.CartDao;
import com.ecom.ecombackend.dao.CartItemsDao;
import com.ecom.ecombackend.dao.CustomerDao;
import com.ecom.ecombackend.dao.OrderedItemsDao;
import com.ecom.ecombackend.dao.OrdersDao;
import com.ecom.ecombackend.dao.ProductDao;
import com.ecom.ecombackend.modclass.Address;
import com.ecom.ecombackend.modclass.Cart;
import com.ecom.ecombackend.modclass.CartItems;
import com.ecom.ecombackend.modclass.Customer;
import com.ecom.ecombackend.modclass.OrderedItems;
import com.ecom.ecombackend.modclass.Orders;
import com.ecom.ecombackend.modclass.Product;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private static final int Quantity = 0;

	@Autowired
	ProductDao productDao;

	@Autowired
	CustomerDao customerDao;

	@Autowired
	CartItemsDao cartItemsDao;

	@Autowired
	CartDao cartDao;

	@Autowired
	OrdersDao ordersDao;

	@Autowired
	OrderedItemsDao orderedItemsDao;

	@Autowired
	AddressDao addressDao;

	@RequestMapping("/addtocart/{productId}")
	public String addtoCart(@PathVariable("productId") int proId, Principal principal, ModelMap m
	/* @RequestParam(value = "Quantity") int Quantity */) {
		Product product = productDao.getProduct(proId);

		Customer customer = customerDao.getCustomerDetails(principal.getName());
		Cart cart = customer.getCart();
		CartItems cartItems = cartItemsDao.getProduct(proId, cart.getCartId());
		if (cartItems == null) {
			cartItems = new CartItems();
			cartItems.setProduct(product);
			cartItems.setCartItemsQuantity(1);
			cartItems.setCart(cart);
			cartItems.setCartItemsPrice(cartItems.getCartItemsQuantity() * product.getProductPrice());
			ArrayList<CartItems> itemsList = new ArrayList<CartItems>();
			itemsList.add(cartItems);
			cart.setCartQuantity(cart.getCartQuantity() + cartItems.getCartItemsQuantity());
			cart.setTotalPrice(cart.getTotalPrice() + cartItems.getCartItemsPrice());
			cart.setCartItems(itemsList);
			m.addAttribute(cartItems);
			cartItemsDao.addCartItems(cartItems);
		} else {
			cartItems.setProduct(product);
			cartItems.setCartItemsPrice(cartItems.getCartItemsPrice() + (Quantity * product.getProductPrice()));
			cartItems.setCartItemsQuantity(cartItems.getCartItemsQuantity() + Quantity);

			ArrayList<CartItems> itemsList = new ArrayList<CartItems>();
			itemsList.add(cartItems);
			cart.setCartQuantity(cart.getCartQuantity() + cartItems.getCartItemsQuantity());
			cart.setTotalPrice(cart.getTotalPrice() + (Quantity * product.getProductPrice()));
			cart.setCartItems(itemsList);
			m.addAttribute("cartItems", itemsList);
			cartItemsDao.updateCartItems(cartItems);
		}

		// cartItemsDao.addCartItems(cartItems);
		cartDao.updateCart(cart);
		// m.addAttribute("cartItems",itemsList);
		m.addAttribute(product);
		m.addAttribute(cart);
		return "redirect:/productInfo/{productId}";
	}

	@RequestMapping("/myCart")
	public String myCart(Model m, Principal principal) {
		Customer customer = customerDao.getCustomerDetails(principal.getName());
		Cart cart = customer.getCart();
		List<CartItems> cartItems = cart.getCartItems();

		m.addAttribute("cartItems", cartItems);
		m.addAttribute(cart);
		return "myCart";
	}

	@RequestMapping("deleteCartItem/{cartItemsId}")
	public String deleteCartItem(@PathVariable("cartItemsId") int id, Model m, Principal principal) {
		CartItems cartItem = cartItemsDao.getCartItems(id);
		Customer customer = customerDao.getCustomerDetails(principal.getName());
		Cart cart = customer.getCart();
		cart.setCartId(cartItem.getCart().getCartId());
		cart.setCartQuantity(cart.getCartQuantity() - cartItem.getCartItemsQuantity());
		cart.setTotalPrice(cart.getTotalPrice() - cartItem.getCartItemsPrice());

		customer.setCart(cart);

		cartDao.updateCart(cart);
		cartItemsDao.deleteCartItems(cartItem);
		return "redirect:/";
	}

	@RequestMapping(value = "/editCartItem/{cartItemsId}")
	public String editCartItem(@PathVariable(value = "cartItemsId") int id, Model m,
			@RequestParam(value = "Quantity") int quantity, Principal principal) {

		CartItems cartItem = cartItemsDao.getCartItems(id);

		System.out.println(cartItem.getCartItemsId());
		Cart cart = cartItem.getCart();

		cart.setCartQuantity(cart.getCartQuantity() - cartItem.getCartItemsQuantity() + quantity);

		cartItem.setCartItemsQuantity(quantity);

		cart.setTotalPrice(cart.getTotalPrice() - cartItem.getCartItemsPrice()
				+ (cartItem.getProduct().getProductPrice() * quantity));

		cartItem.setCartItemsPrice(cartItem.getProduct().getProductPrice() * quantity);

		cartItemsDao.updateCartItems(cartItem);

		cartDao.updateCart(cart);

		return "redirect:/";

	}

	@RequestMapping("/checkout/{cartId}")
	public String checkout(@PathVariable("cartId") int cartId, Principal principal, Model m) {

		Customer customer = customerDao.getCustomerDetails(principal.getName());

		m.addAttribute("customer", customer);
		Cart cart = customer.getCart();

		m.addAttribute("cart", cart);
		List<CartItems> cartItems = cart.getCartItems();
		m.addAttribute("cartItems", cartItems);
		return "checkout";
	}

	@RequestMapping("/order/{cartId}")
	public String order(@PathVariable("cartId") int cartId, Principal principal, Model m) {

		Customer customer = customerDao.getCustomerDetails(principal.getName());

		m.addAttribute("customer", customer);
		Cart cart = customer.getCart();
		Orders orders = new Orders();

		orders.setCart(cart);

		List<CartItems> cartItems = cart.getCartItems();

		List<OrderedItems> orderedItemsList = new ArrayList();

		cart.setCartQuantity(0);
		cart.setTotalPrice(0);
		cartDao.updateCart(cart);

		for (CartItems items : cartItems) {
			OrderedItems orderedItems = new OrderedItems();

			orderedItems.setProduct(items.getProduct());
			orderedItems.setOrderedItemsTotalQuantity(items.getCartItemsQuantity());
			orderedItems.setOrderedItemsTotalPrice(items.getCartItemsPrice());
			orderedItems.setUnitPrice(items.getProduct().getProductPrice());
			orderedItems.setOrders(orders);
			if (orders.getOrderQuantity() == 0) {
				orders.setOrderQuantity(0);
			}
			orders.setOrderQuantity(orders.getOrderQuantity() + orderedItems.getOrderedItemsTotalQuantity());
			if (orders.getOrderTotalPrice() == 0) {
				orders.setOrderTotalPrice(0);
			}
			orders.setOrderTotalPrice(orders.getOrderTotalPrice() + orderedItems.getOrderedItemsTotalPrice());
			orderedItemsList.add(orderedItems);
			cartItemsDao.deleteCartItems(items);
		}
		orders.setOrderedItems(orderedItemsList);
		ordersDao.placeOrders(orders);

		for (OrderedItems orderedItems : orderedItemsList) {
			orderedItemsDao.addOrderedItems(orderedItems);
		}
		m.addAttribute("orders", orders);
		m.addAttribute("cart", cart);
		return "order";
	}

	@RequestMapping("/address/{cartId}")
	public String address(@PathVariable("cartId") int cartId, Principal principal, Model m) {
		Customer customer = customerDao.getCustomerDetails(principal.getName());
		if (customer.getAddress() != null) {
			m.addAttribute("address", customer.getAddress());
		} else {
			m.addAttribute("address", new Address());
		}

		return "address";
	}

	@RequestMapping("/addressProcess")
	public String addAddress(@ModelAttribute("address") Address address, Principal principal, Model m) {

		Customer customer = customerDao.getCustomerDetails(principal.getName());

		address.setCustomer(customer);
		addressDao.addAddress(address);
		customer.setAddress(address);
		customerDao.updateCustomer(customer);

		Cart cart = customer.getCart();

		return "redirect:/customer/order/" + cart.getCartId();
	}

}
