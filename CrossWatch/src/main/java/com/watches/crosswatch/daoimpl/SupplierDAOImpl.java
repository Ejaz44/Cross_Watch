package com.watches.crosswatch.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.watches.crosswatch.dao.SupplierDAO;
import com.watches.crosswatch.model.Supplier;

@Repository
public class SupplierDAOImpl implements SupplierDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public void addSupplier(Supplier supplier) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
	}

	public List<Supplier> getList() 
	{
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Supplier";
		@SuppressWarnings("unchecked")
		List<Supplier> supplierList = session.createQuery(hql).getResultList();
		return supplierList;
	}

	public Supplier getListById(int supplierId) 
	{
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Supplier where supplierId="+supplierId;
		@SuppressWarnings("unchecked")
		List<Supplier> supplierListById = session.createQuery(hql).getResultList();
		return supplierListById.get(0);
	}

	public void deleteSupplier(int supplierId) 
	{
		Supplier supplierToDelete = new Supplier();
		supplierToDelete.setSupplierId(supplierId);
		sessionFactory.getCurrentSession().delete(supplierToDelete);
	}

	public Supplier getSupplierByName(String supplierName) 
	{
		Session session = sessionFactory.getCurrentSession();
		String hql="from Supplier where supplierName="+"'"+supplierName+"'";
		@SuppressWarnings("unchecked")
		List<Supplier> supplierByID=session.createQuery(hql).getResultList();
		return supplierByID.get(0);
	}
	
	public String getJsonSupplierList() 
	{
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Supplier";
		@SuppressWarnings("unchecked")
		List<Supplier> supplierList = session.createQuery(hql).getResultList();
		
		Gson gson = new Gson();
		String jsonList = gson.toJson(supplierList);
		return jsonList;
	}

}