package com.watches.crosswatch.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.watches.crosswatch.dao.BrandDAO;
import com.watches.crosswatch.model.Brand;

@Repository
public class BrandDAOImpl implements BrandDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public void addBrand(Brand brand) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(brand);
	}

	public List<Brand> getList() 
	{
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Brand";
		@SuppressWarnings("unchecked")
		List<Brand> brandList=session.createQuery(hql).getResultList();
		return brandList;
	}

	
	public Brand getListById(int brandId) 
	{
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Brand where brandId="+brandId;
		@SuppressWarnings("unchecked")
		List<Brand> brandListById = session.createQuery(hql).getResultList();
		return brandListById.get(0);
	}

	public void deleteBrand(int brandId) 
	{
		Brand brandToDelete = new Brand();
		brandToDelete.setBrandId(brandId);
		sessionFactory.getCurrentSession().delete(brandToDelete);
	}

	public Brand getBrandByName(String brandName) 
	{
		Session session = sessionFactory.getCurrentSession();
		String hql="from Brand where brandName="+"'"+brandName+"'";
		@SuppressWarnings("unchecked")
		List<Brand> brandById = session.createQuery(hql).getResultList();
		return brandById.get(0);
	}
	
	public String getJsonBrandList() 
	{
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Brand";
		@SuppressWarnings("unchecked")
		List<Brand> brandList=session.createQuery(hql).getResultList();
		
		Gson gson = new Gson();
		String jsonList = gson.toJson(brandList);
		return jsonList;
	}

}
