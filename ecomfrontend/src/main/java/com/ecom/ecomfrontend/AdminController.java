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
import com.ecom.ecombackend.modclass.Product;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	CustomerDao customerDao;

	@Autowired
	ProductDao productDao;

	@Autowired
	CategoryDao categoryDao;

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
		System.err.println("productId " + product.getProductId());
		if (product.getProductId() != 0) {
			productDao.updateProduct(product);
		} else {
			productDao.addProduct(product);
		}
		// String path =
		// "C:/Users/Vaibhav/Workspace2/GadgetHack/ecomfrontend/src/main/webapp/resources/images/";
		String path = request.getServletContext().getRealPath("/resources/images/");
		File f=new File(path);
		if(!f.exists())
		{
			f.mkdirs();
		}
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
		return "redirect:/admin/product";
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
		// System.err.println("categoryId "+category.getCategoryId());
		if (category.getCategoryId() != 0) {
			System.out.println("hello");
			categoryDao.updateCategory(category);
		} else {
			categoryDao.addCategory(category);
		}
		return "redirect:/admin/category";
	}

	@RequestMapping("/editProduct/{productId}")
	public String editProduct(@PathVariable("productId") int prodId, Model m) {
		Product product = productDao.getProduct(prodId);
		m.addAttribute("product", product);
		List<Product> productList = productDao.retreiveAllProducts();
		m.addAttribute("productList", productList);
		List<Category> categoryList = categoryDao.retreiveAllCategories();
		m.addAttribute("categoryList", categoryList);
		return "product";
	}

	@RequestMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") int prodId, Model m) {
		Product product = productDao.getProduct(prodId);
		productDao.deleteProduct(product);
		Product pro = new Product();
		m.addAttribute("product", pro);
		List<Product> productList = productDao.retreiveAllProducts();
		m.addAttribute("productList", productList);
		List<Category> categoryList = categoryDao.retreiveAllCategories();
		m.addAttribute("categoryList", categoryList);

		return "product";
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


	@RequestMapping("/editCategory/{categoryId}")
	public String editCategory(@PathVariable("categoryId") Integer catId, Model m) {
		Category category = categoryDao.getCategory(catId);
		m.addAttribute("category", category);
		List<Product> productList = productDao.retreiveAllProducts();
		m.addAttribute("productList", productList);
		List<Category> categoryList = categoryDao.retreiveAllCategories();
		m.addAttribute("categoryList", categoryList);
		return "category";
	}

	@RequestMapping("/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") int catId, Model m) {
		Category category = categoryDao.getCategory(catId);
		categoryDao.deleteCategory(category);
		Category cat = new Category();
		m.addAttribute("category", cat);
		List<Product> productList = productDao.retreiveAllProducts();
		m.addAttribute("productList", productList);
		List<Category> categoryList = categoryDao.retreiveAllCategories();
		m.addAttribute("categoryList", categoryList);
		return "category";
	}

}
