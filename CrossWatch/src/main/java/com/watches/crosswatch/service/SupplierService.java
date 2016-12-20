package com.watches.crosswatch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.watches.crosswatch.daoimpl.SupplierDAOImpl;
import com.watches.crosswatch.model.Supplier;

@Service
@Transactional
public class SupplierService 
{
	@Autowired
	SupplierDAOImpl supplierDAOImpl;
	
	public void addSupplier(Supplier supplier)
	{
		supplierDAOImpl.addSupplier(supplier);
	}
	
	public List<Supplier> getList()
	{
		return supplierDAOImpl.getList();
	}
	
	public Supplier getListById(int supplierId)
	{
		return supplierDAOImpl.getListById(supplierId);
	}
	
	public void deleteSupplier(int supplierId)
	{
		supplierDAOImpl.deleteSupplier(supplierId);
	}
	
	public Supplier getSupplierByName(String supplierName)
	{
		return supplierDAOImpl.getSupplierByName(supplierName);
	}
	
	public String getJsonSupplierList()
	{
		return supplierDAOImpl.getJsonSupplierList();
	}
}