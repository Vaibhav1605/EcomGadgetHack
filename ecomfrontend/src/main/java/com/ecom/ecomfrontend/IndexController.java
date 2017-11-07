package com.ecom.ecomfrontend;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ecom.ecombackend.dao.CategoryDao;
import com.ecom.ecombackend.dao.CustomerDao;
import com.ecom.ecombackend.dao.ProductDao;
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

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@RequestMapping("/index")
	public ModelAndView home() {
		return new ModelAndView("index");
	}

	@RequestMapping("/signUp")
	public ModelAndView registration(Model m) {
		Customer customer = new Customer();
		m.addAttribute(customer);
		return new ModelAndView("signUp");
	}

	@RequestMapping(value = "/signUpProcess", method = RequestMethod.POST)
	public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerDao.addCustomer(customer);
		return new ModelAndView("index");
	}

	@RequestMapping("/product")
	public ModelAndView product(Model m) {
		Product product = new Product();
		m.addAttribute(product);
		List<Product> productList = productDao.retreiveAllProducts();
		m.addAttribute("productList", productList);
		List<Category> categoryList = categoryDao.retreiveAllCategories();
		m.addAttribute("categoryList", categoryList);
		return new ModelAndView("product");
	}

	@RequestMapping(value = "/productProcess", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product,
			@RequestParam("productImage") MultipartFile multiPartFile, Model m) {
		/*
		 * System.out.println(product.getProductName());
		 * System.out.println("product cat"+product.getCategory());
		 */
		productDao.addProduct(product);
		String path = "C:/Users/Vaibhav/Workspace2/GadgetHack/ecomfrontend/src/main/webapp/resources/images/";
		String totalFileWithPath = path + String.valueOf(product.getProductId()) + ".jpg";
		File productImage = new File(totalFileWithPath);
		if (!multiPartFile.isEmpty()) {
			try {
				byte fileBuffer[] = multiPartFile.getBytes();
				FileOutputStream fileOutputStream = new FileOutputStream(productImage);
				BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
				bufferedOutputStream.write(fileBuffer);
				bufferedOutputStream.close();
			} catch (Exception e) {
				System.out.println(e);
				m.addAttribute("File Exception" + e);
			}
		} else {
			m.addAttribute("Error", "Problem in File Uploading");
		}

		/*
		 * List<Product> productList= productDao.retreiveAllProducts();
		 * m.addAttribute("productLists",productList); Product product1=new
		 * Product(); m.addAttribute(product1);
		 */
		return "redirect:/product";
	}
}
