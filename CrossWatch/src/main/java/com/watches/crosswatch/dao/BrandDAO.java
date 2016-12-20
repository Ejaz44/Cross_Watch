package com.watches.crosswatch.dao;

import java.util.List;

import com.watches.crosswatch.model.Brand;

public interface BrandDAO 
{
	public void addBrand(Brand brand);
	
	public List<Brand> getList();
	
	public Brand getListById(int brandId);
	
	public void deleteBrand(int brandId);
	
	public Brand getBrandByName(String brandName);
}
