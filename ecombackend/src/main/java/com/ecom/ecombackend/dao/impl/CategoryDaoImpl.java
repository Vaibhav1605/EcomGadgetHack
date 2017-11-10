package com.ecom.ecombackend.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.ecombackend.dao.CategoryDao;
import com.ecom.ecombackend.modclass.Category;
import com.ecom.ecombackend.modclass.Product;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addCategory(Category category) {
		try {

			sessionFactory.getCurrentSession().save(category);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean deleteCategory(Category category) {

		try {

			sessionFactory.getCurrentSession().delete(category);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Category getCategory(Integer id) {
		try {
			return sessionFactory.getCurrentSession().get(Category.class, id);
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> retreiveAllCategories() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Category").getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;

		}

	}

	@Override
	public Integer getCatId(String catName) {
		// TODO Auto-generated method stub
		try {

			Category cat = sessionFactory.getCurrentSession()
					.createQuery("from Category where categoryName=:catName", Category.class)
					.setParameter("catName", catName).getSingleResult();
			return cat.getCategoryId();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;

		}
	}

	@Override
	public List<Product> getretrieveAllProdutsOfCategory(String categoryName) {
		// TODO Auto-generated method stub
		try {
			Integer id = getCatId(categoryName);
			return sessionFactory.getCurrentSession()
					.createQuery("from Product where category_categoryid=:catid", Product.class)
					.setParameter("catid", id).getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}

	}
}
