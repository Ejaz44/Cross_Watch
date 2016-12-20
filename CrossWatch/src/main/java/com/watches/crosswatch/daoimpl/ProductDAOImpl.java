package com.watches.crosswatch.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.watches.crosswatch.dao.ProductDAO;
import com.watches.crosswatch.model.Product;


@Repository
public class ProductDAOImpl implements ProductDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public void addProduct(Product product) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		
	}

	public List<Product> getList() 
	{
		Session session = sessionFactory.getCurrentSession();
		String hql="from Product";
		@SuppressWarnings("unchecked")
		List<Product> productList=session.createQuery(hql).getResultList();
		return productList;
	}

	public Product getListById(int productId) 
	{
		Session session = sessionFactory.getCurrentSession();
		String hql="from Product where productId="+productId;
		@SuppressWarnings("unchecked")
		List<Product> productListById = session.createQuery(hql).getResultList();
		return productListById.get(0);
	}

	public void deleteProduct(int productId) 
	{
		Product productToDelete = new Product();
		productToDelete.setProductId(productId);
		sessionFactory.getCurrentSession().delete(productToDelete);
		
	}

	public String getJsonProductList() 
	{
		Session session = sessionFactory.getCurrentSession();
		String hql="from Product";
		@SuppressWarnings("unchecked")
		List<Product> productList=session.createQuery(hql).getResultList();
		
		Gson gson = new Gson();
		String jsonList = gson.toJson(productList);
		return jsonList;
	}
}
