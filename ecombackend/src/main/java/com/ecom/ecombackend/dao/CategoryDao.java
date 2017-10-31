package com.ecom.ecombackend.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ecom.ecombackend.modclass.Category;

@Component
public interface CategoryDao {

	public boolean addCategory(Category category);

	public boolean deleteCategory(Category category);

	public boolean updateCategory(Category category);

	public Category getCategory(Integer id);

	List<Category> retreiveAllCategories();

}
