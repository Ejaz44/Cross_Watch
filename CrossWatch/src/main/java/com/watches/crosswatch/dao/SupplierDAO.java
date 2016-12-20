package com.watches.crosswatch.dao;

import java.util.List;

import com.watches.crosswatch.model.Supplier;

public interface SupplierDAO 
{
	public void addSupplier(Supplier supplier);
	
	public List<Supplier> getList();
	
	public Supplier getListById(int supplierId);
	
	public void deleteSupplier(int supplierId);
	
	public Supplier getSupplierByName(String supplierName);
}
