package com.watches.crosswatch.daoimpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.watches.crosswatch.dao.CategoryDAO;
import com.watches.crosswatch.model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public void addCategory(Category category) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(category);
	}

	public List<Category> getList() 
	{
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Category";
		@SuppressWarnings("unchecked")
		List<Category> categoryList = session.createQuery(hql).getResultList();
		return categoryList;
	}

	public Category getListById(int categoryId) 
	{
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Category where categoryId="+categoryId;
		@SuppressWarnings("unchecked")
		List<Category> categoryListById= session.createQuery(hql).getResultList();
		return categoryListById.get(0);
	}

	public void deleteCategory(int categoryId) 
	{
		Category categoryToDelete = new Category();
		categoryToDelete.setCategoryId(categoryId);
		sessionFactory.getCurrentSession().delete(categoryToDelete);
	}

	public Category getCategoryByName(String categoryName) 
	{
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Category where categoryName = "+"'"+categoryName+"'";
		@SuppressWarnings("unchecked")
		List<Category> categoryById = session.createQuery(hql).getResultList();
		return categoryById.get(0);
	}
	
	public String getJsonCategoryList() 
	{
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Category";
		@SuppressWarnings("unchecked")
		List<Category> getList = session.createQuery(hql).getResultList();
		Gson gson = new Gson();
		String jsonList = gson.toJson(getList);
		return jsonList;
		
	}
}