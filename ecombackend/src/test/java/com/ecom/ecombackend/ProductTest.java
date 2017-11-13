package com.ecom.ecombackend;

import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.ecombackend.dao.CategoryDao;
import com.ecom.ecombackend.dao.ProductDao;
import com.ecom.ecombackend.modclass.Category;
import com.ecom.ecombackend.modclass.Product;

public class ProductTest {
	// we have to declare reference variables here to access it in any method
	AnnotationConfigApplicationContext context;
	ProductDao productDao;
	Product product;
	CategoryDao categoryDao;
	Category category;
	Category products;

	@Before
	public void init() {
		// making object of AnnotationConfigApplicationContext
		context = new AnnotationConfigApplicationContext();
		// scanning the whole project for making bean objects
		context.scan("com.ecom.ecombackend");
		// refresh the Spring Container
		context.refresh();
		// getting the beans of productDao type
		productDao = (ProductDao) context.getBean("productDao");
		// Creating the object of POJO class or Transaction manager
		product = new Product();
		// getting the beans of productDao type
		categoryDao = (CategoryDao) context.getBean("categoryDao");
		// Creating the object of POJO class or Transaction manager

	}

	@Test
	public void productAddTest() {
		category = categoryDao.getCategory(1); // getting category details
												// using categoryId
		product.setProductName("DSLR");
		product.setProductDesc("SONY 2600Dwith 24mp");
		product.setProductPrice(35000.00);
		product.setCategory(category); // Adding details of category to products
		Product pro = new Product();
		pro.setCategory(category);
		pro.setProductName("DSLR");
		pro.setProductDesc("FujiFilm 3200D with 20mp");
		pro.setProductPrice(20000.00); // Setting product data
		Collection<Product> products = category.getProducts();
		products.add(product);
		products.add(pro);
		category.setProducts(products); // setting product data in category
		productDao.addProduct(pro); // Adding product data to product table
		productDao.addProduct(product);
		categoryDao.updateCategory(category); // Updating category table
	}
	/*
	 * @Test public void productDeleteTest() { product.setProductId(3);
	 * Assert.assertEquals("Data Deleted",true,productDao.deleteProduct(product)
	 * ); }
	 * 
	 * @Test public void productGetTest() { product = productDao.getProduct(1);
	 * 
	 * Assert.assertNotNull(product);
	 * System.out.println(product.getProductName());
	 * System.out.println(product.getProductDesc());
	 * System.out.println(product.getProductPrice()); }
	 * 
	 * @Test public void productUpdateTest() { 
	 * product=productDao.getProduct(2);
	 * product.setProductName("iPhone"); 
	 * product.setProductDesc("Apple Mobile");
	 * Assert.assertEquals("Updated",true,productDao.updateProduct(product)); }
	 * 
	 * @Test public void productListTest() { 
	 * List<product> productList=productDao.getALLproduct(); boolean
	 * boolean=productList.hasNext(); 
	 * System.out.println(productList.size());
	 * //Assert.assertEquals("",true,productList.isEmpty());
	 * //Assert.assertThat(productList, not(IsEmptyList.empty())); }
	 */

}