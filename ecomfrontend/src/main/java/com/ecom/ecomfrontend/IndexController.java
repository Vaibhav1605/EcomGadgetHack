package com.ecom.ecomfrontend;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecom.ecombackend.dao.CartDao;
import com.ecom.ecombackend.dao.CategoryDao;
import com.ecom.ecombackend.dao.CustomerDao;
import com.ecom.ecombackend.dao.ProductDao;
import com.ecom.ecombackend.modclass.Cart;
import com.ecom.ecombackend.modclass.CartItems;
import com.ecom.ecombackend.modclass.Category;
import com.ecom.ecombackend.modclass.Customer;
import com.ecom.ecombackend.modclass.Product;

@Controller
public class IndexController {

	@Autowired
	CustomerDao customerDao;

	@Autowired
	ProductDao productDao;

	@Autowired
	CategoryDao categoryDao;

	@Autowired
	CartDao cartDao;

	@RequestMapping("/")
	public ModelAndView index(Model m, Principal principal) {

		List<Product> productList = productDao.retreiveAllProducts();
		m.addAttribute("productList", productList);
		List<Category> categoryList = categoryDao.retreiveAllCategories();
		m.addAttribute("categoryList", categoryList);
		if (principal != null) {
			Customer customer = customerDao.getCustomerDetails(principal.getName());
			if (customer.getRole() != ("ROLE_ADMIN")) {
				Cart cart = customer.getCart();
				List<CartItems> cartItems = cart.getCartItems();

				m.addAttribute("cartItems", cartItems);
				m.addAttribute(cart);
			}
		}
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/categoryItems/{categoryName}", method = RequestMethod.GET)
	public ModelAndView categoryInfo(@PathVariable(value = "categoryName") String categoryName, Model m,
			Principal principal) {
		m.addAttribute("products", categoryDao.getretrieveAllProdutsOfCategory(categoryName));
		List<Product> productList = productDao.retreiveAllProducts();
		m.addAttribute("productList", productList);
		List<Category> categoryList = categoryDao.retreiveAllCategories();
		m.addAttribute("categoryList", categoryList);
		if (principal != null) {
			Customer customer = customerDao.getCustomerDetails(principal.getName());
			if (!customer.getRole().equals("ROLE_ADMIN")) {
				Cart cart = customer.getCart();
				List<CartItems> cartItems = cart.getCartItems();

				m.addAttribute("cartItems", cartItems);
				m.addAttribute(cart);
			}
		}
		return new ModelAndView("categoryItems");
	}

	@RequestMapping("/index")
	public ModelAndView home(Model m, Principal principal) {
		List<Product> productList = productDao.retreiveAllProducts();
		m.addAttribute("productList", productList);
		List<Category> categoryList = categoryDao.retreiveAllCategories();
		m.addAttribute("categoryList", categoryList);
		if (principal != null) {
			Customer customer = customerDao.getCustomerDetails(principal.getName());
			if (customer.getRole() != ("ROLE_ADMIN")) {
				Cart cart = customer.getCart();
				List<CartItems> cartItems = cart.getCartItems();

				m.addAttribute("cartItems", cartItems);
				m.addAttribute(cart);
			}
		}
		return new ModelAndView("index");
	}

	@RequestMapping("/signUp")
	public ModelAndView signUp(Model m, Principal principal) {
		List<Product> productList = productDao.retreiveAllProducts();
		m.addAttribute("productList", productList);
		List<Category> categoryList = categoryDao.retreiveAllCategories();
		m.addAttribute("categoryList", categoryList);
		Customer customer = new Customer();
		m.addAttribute(customer);
		return new ModelAndView("signUp");
	}

	@RequestMapping(value = "/signUpProcess", method = RequestMethod.POST)
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model m) {
		if (result.hasErrors()) {
			m.addAttribute(customer);
			return "signUp";
		} else {

			System.out.println(customer.getConfirmPassword() + "   " + customer.getPassword());
			if (!(customer.getPassword().equals(customer.getConfirmPassword()))) {
				m.addAttribute("passerror", "password and confirm password should be same");
				m.addAttribute(customer);
				return "signUp";
			} else {
				Cart cart = new Cart();
				cart.setCustomer(customer);
				customer.setCart(cart);
				customerDao.addCustomer(customer);
				cartDao.addCart(cart);
				return "redirect:/login";
			}
		}
	}

	@RequestMapping(value = "/productInfo/{productId}", method = RequestMethod.GET)
	public ModelAndView productInfo(@PathVariable(value = "productId") Integer productId, Model m,
			Principal principal) {
		m.addAttribute("product", productDao.getProduct(productId));

		List<Product> productList = productDao.retreiveAllProducts();
		m.addAttribute("productList", productList);
		if (principal != null) {
			Customer customer = customerDao.getCustomerDetails(principal.getName());
			if (customer.getRole() != ("ROLE_ADMIN")) {
				Cart cart = customer.getCart();
				List<CartItems> cartItems = cart.getCartItems();

				m.addAttribute("cartItems", cartItems);
				m.addAttribute(cart);
			}
		}

		return new ModelAndView("productInfo");
	}

	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(value = "error", required = false) String error, Model m) {
		System.out.println(error);
		if (error != null) {
			m.addAttribute("error", "Authentication Failed - Invalid credentials!");
		}

		List<Product> productList = productDao.retreiveAllProducts();
		m.addAttribute("productList", productList);
		List<Category> categoryList = categoryDao.retreiveAllCategories();
		m.addAttribute("categoryList", categoryList);
		System.out.println("loggedin");
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/createOne")
	public ModelAndView createOne(Model m) {
		List<Product> productList = productDao.retreiveAllProducts();
		m.addAttribute("productList", productList);
		List<Category> categoryList = categoryDao.retreiveAllCategories();
		m.addAttribute("categoryList", categoryList);
		return new ModelAndView("signUp");
	}

	/*
	 * @RequestMapping("/customer/addToCart/{productId}") public String
	 * addToCart(@PathVariable("productId") int proid,Model m) {
	 * productDao.getProduct(proid); return "redirect:/"; }
	 */

}