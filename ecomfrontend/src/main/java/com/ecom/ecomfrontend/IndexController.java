package com.ecom.ecomfrontend;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ecom.ecombackend.dao.CustomerDao;
import com.ecom.ecombackend.dao.ProductDao;
import com.ecom.ecombackend.modclass.Customer;
import com.ecom.ecombackend.modclass.Product;


@Controller
public class IndexController {
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping("/")
	public ModelAndView index()
	{
		
		return new ModelAndView("index");
	}

	@RequestMapping("/index")
	public ModelAndView home()
	{
		return new ModelAndView("index");
	}
	
	
	@RequestMapping("/SignUp")
	public ModelAndView product(Model m)
	{
		Customer customer=new Customer();
		m.addAttribute(customer);
		return new ModelAndView("SignUp");
	}
	
	@RequestMapping(value = "/signUpProcess", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customer") Customer customer, Model m)
	{
		
		customerDao.addCustomer(customer);
		
		return "index";
		
	}

	@RequestMapping("/Product")
	public ModelAndView products(Model m)
	{
		Product product = new Product();
		m.addAttribute(product);

		List<Product> listProducts = productDao.retreiveAllProducts();
		m.addAttribute("prodlist", listProducts);
		return new ModelAndView("Product");
	}
	
	@RequestMapping(value = "/prodProcess", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("Product") Product product, Model m)
	{
		
		productDao.addProduct(product);
		List<Product> listProducts = productDao.retreiveAllProducts();
		m.addAttribute("prodlist", listProducts);
		return "index";
		
	}

}
