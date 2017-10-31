package com.ecom.ecombackend.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.ecombackend.dao.CategoryDao;
import com.ecom.ecombackend.modclass.Category;



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

	

}
