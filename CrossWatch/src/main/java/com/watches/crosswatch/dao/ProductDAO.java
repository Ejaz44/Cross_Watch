package com.watches.crosswatch.dao;

import java.util.List;

import com.watches.crosswatch.model.Product;

public interface ProductDAO 
{
	public void addProduct(Product product);

	public List<Product> getList();
	
	public Product getListById(int productId);
	
	public void deleteProduct(int productId);
}
