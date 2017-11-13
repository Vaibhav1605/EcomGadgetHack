package com.ecom.ecomfrontend;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ecom.ecombackend.dao.CartDao;
import com.ecom.ecombackend.dao.CategoryDao;
import com.ecom.ecombackend.dao.CustomerDao;
import com.ecom.ecombackend.dao.ProductDao;
import com.ecom.ecombackend.modclass.Cart;
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
	public ModelAndView index(Model m) {

		List<Product> productList = productDao.retreiveAllProducts();
		m.addAttribute("productList", productList);
		List<Category> categoryList = categoryDao.retreiveAllCategories();
		m.addAttribute("categoryList", categoryList);
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/categoryItems/{categoryName}", method = RequestMethod.GET)
	public ModelAndView categoryInfo(@PathVariable(value = "categoryName") String categoryName, Model m) {
		m.addAttribute("products", categoryDao.getretrieveAllProdutsOfCategory(categoryName));
		List<Product> productList = productDao.retreiveAllProducts();
		m.addAttribute("productList", productList);
		List<Category> categoryList = categoryDao.retreiveAllCategories();
		m.addAttribute("categoryList", categoryList);
		return new ModelAndView("categoryItems");
	}

	@RequestMapping("/index")
	public ModelAndView home(Model m) {
		List<Product> productList = productDao.retreiveAllProducts();
		m.addAttribute("productList", productList);
		List<Category> categoryList = categoryDao.retreiveAllCategories();
		m.addAttribute("categoryList", categoryList);
		return new ModelAndView("index");
	}
	
	
	@RequestMapping("/signUp")
	public ModelAndView signUp(Model m) {
		List<Product> productList = productDao.retreiveAllProducts();
		m.addAttribute("productList", productList);
		List<Category> categoryList = categoryDao.retreiveAllCategories();
		m.addAttribute("categoryList", categoryList);
		Customer customer = new Customer();
		m.addAttribute(customer);
		return new ModelAndView("signUp");
	}

	@RequestMapping(value = "/signUpProcess", method = RequestMethod.POST)
	public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
		Cart cart = new Cart();
		cart.setCustomer(customer);
		customer.setCart(cart);
		customerDao.addCustomer(customer);
		cartDao.addCart(cart);
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(value = "error", required = false) String error, Model m) {
		System.out.println(error);
		if (error != null) {
			m.addAttribute("error", "Authentication Failed - Invalid credentials!");
		}

		m.addAttribute("title", "Login");
		m.addAttribute("login", true);
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

	
}