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
	public ModelAndView index(Model m) {

		List<Product> productList = productDao.retreiveAllProducts();
		m.addAttribute("productList", productList);
		List<Category> categoryList = categoryDao.retreiveAllCategories();
		m.addAttribute("categoryList", categoryList);
		return new ModelAndView("index");
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
		customerDao.addCustomer(customer);
		return new ModelAndView("login");
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
			@RequestParam("productImage") MultipartFile multiPartFile, Model m, HttpServletRequest request) {
		/*
		 * System.out.println(product.getProductName());
		 * System.out.println("product cat"+product.getCategory());
		 */
		productDao.addProduct(product);
		// String path =
		// "C:/Users/Vaibhav/Workspace2/GadgetHack/ecomfrontend/src/main/webapp/resources/images/";
		String path = request.getServletContext().getRealPath("/resources/images/");
		String totalFileWithPath = path + String.valueOf(product.getProductName()) + ".jpg";
		System.out.println(totalFileWithPath);
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

	@RequestMapping(value = "/productInfo/{productId}", method = RequestMethod.GET)
	public ModelAndView productInfo(@PathVariable(value = "productId") Integer productId, Model m) {
		m.addAttribute("product", productDao.getProduct(productId));
		/*
		 * List<Product> productList = productDao.retreiveAllProducts();
		 * m.addAttribute("productList", productList);
		 */
		return new ModelAndView("productInfo");
	}

	@RequestMapping("/login")
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
		return new ModelAndView("login");
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

	@RequestMapping("/category")
	public ModelAndView category(Model m) {
		Category category = new Category();
		m.addAttribute(category);
		List<Product> productList = productDao.retreiveAllProducts();
		m.addAttribute("productList", productList);
		List<Category> categoryList = categoryDao.retreiveAllCategories();
		m.addAttribute("categoryList", categoryList);
		return new ModelAndView("category");
	}

	@RequestMapping(value = "/categoryProcess", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute("category") Category category, Model m, HttpServletRequest request) {
		categoryDao.addCategory(category);
		return "redirect:/category";
	}
}