package com.ecom.ecombackend;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.ecombackend.dao.CategoryDao;
import com.ecom.ecombackend.modclass.Category;

public class CategoryTest {
	//we have to declare reference variables here to access it in any method
			AnnotationConfigApplicationContext context;
			CategoryDao categoryDao;
			Category category;
		 
		    @Before
		    public void init()
		    {
		    	//making object of AnnotationConfigApplicationContext
		    	context=new AnnotationConfigApplicationContext();
		    	//scanning the whole project for making bean objects
		    	context.scan("com.ecom.ecombackend");
		    	//refresh the Spring Container 
		    	context.refresh();
		    	//getting the beans of productDao type
		    	categoryDao=(CategoryDao) context.getBean("categoryDao");
		    	//Creating the object of POJO class or Transaction manager
		    	category=new Category();
		    }
		    @Test  
		    public void categoryAddTest()  
		     {  
		    	
		    	 category.setCategoryId(1);
		    	 category.setCategoryName("DSLR");
		    	 category.setCategoryDesc("Canon 3200D");
		 		 Assert.assertEquals("Data Entered Ureka",true,categoryDao.addCategory(category));  
		     }
		    
//		     @Test
//		     public void categoryDeleteTest()
//		     {
//		    	 category.setCategoryId(2);
//		    	 Assert.assertEquals("Data Deleted",true,categoryDao.deleteCategory(category));
//		     }
//		     
//		     @Test  
//		     public void categoryGetTest() {  
//		    	 category = categoryDao.getCategory(1);  
//		         
//		         Assert.assertNotNull(category);
//		        // System.out.println(category.getCategoryId());
//		         System.out.println(category.getCategoryName());
//		         System.out.println(category.getCategoryDesc());
//		         }
//		     
//		    @Test 
//		    public void categoryUpdateTest()
//		    {
//		    	category=categoryDao.getCategory(1);
//		    	category.setCategoryName("DSLR");
//		    	category.setCategoryDesc("Nikon 700D");
//		    	Assert.assertEquals("Updated",true,categoryDao.updateCategory(category));
//		    }
//		   /*
//		    @Test
//		    public void categoryListTest()
//		    {
//		    	List<category> categoryList=categoryDao.getALLcategory();
//		    	boolean boolean=categoryList.hasNext();
//		    	System.out.println(categoryList.size());
//		    	//Assert.assertEquals("",true,categoryList.isEmpty());
//		    	//Assert.assertThat(categoryList, not(IsEmptyList.empty()));
//		    }*/
//

}
