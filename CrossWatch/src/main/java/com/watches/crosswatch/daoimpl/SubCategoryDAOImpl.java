package com.watches.crosswatch.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.watches.crosswatch.dao.SubCategoryDAO;
import com.watches.crosswatch.model.SubCategory;

@Repository
public class SubCategoryDAOImpl implements SubCategoryDAO
{
	@Autowired
	SessionFactory sessionFactory;
	public void addSubCategory(SubCategory subCategory) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(subCategory);
	}
	public List<SubCategory> getList() 
	{
		Session session = sessionFactory.getCurrentSession();
		String hql="from SubCategory";
		@SuppressWarnings("unchecked")
		List<SubCategory> subCategoryList = session.createQuery(hql).getResultList();
		return subCategoryList;
	}
	public SubCategory getListById(int subCategoryId) 
	{
		Session session = sessionFactory.getCurrentSession();
		String hql = "from SubCategory where subCategoryId="+subCategoryId;
		@SuppressWarnings("unchecked")
		List<SubCategory> subCategoryListById= session.createQuery(hql).getResultList();
		return subCategoryListById.get(0);
		
	}
	public void deleteSubCategory(int subCategoryId) 
	{
		SubCategory subCategoryToDelete = new SubCategory();
		subCategoryToDelete.setSubCategoryId(subCategoryId);
		sessionFactory.getCurrentSession().delete(subCategoryToDelete);
	}
	public SubCategory getSubCategoryByName(String subCategoryName) 
	{
		Session session = sessionFactory.getCurrentSession();
		String hql="from SubCategory where subCategoryName ="+"'"+subCategoryName+"'";
		@SuppressWarnings("unchecked")
		List<SubCategory> subCategoryById = session.createQuery(hql).getResultList();
		return subCategoryById.get(0);
	}
	
	public String getJsonSubCategoryList() 
	{
		Session session = sessionFactory.getCurrentSession();
		String hql="from SubCategory";
		@SuppressWarnings("unchecked")
		List<SubCategory> subCategoryList = session.createQuery(hql).getResultList();
		
		Gson gson = new Gson();
		String jsonList = gson.toJson(subCategoryList);
		return jsonList;
	}
}
