package com.watches.crosswatch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.watches.crosswatch.daoimpl.BrandDAOImpl;
import com.watches.crosswatch.model.Brand;

@Service
@Transactional
public class BrandService 
{
	@Autowired
	BrandDAOImpl brandDAOImpl;
	
	public void addBrand(Brand brand)
	{
		brandDAOImpl.addBrand(brand);
	}
	
	public List<Brand> getList()
	{
		return brandDAOImpl.getList();
	}
	
	public Brand getListById(int brandId)
	{
		return brandDAOImpl.getListById(brandId);
	}
	
	public void deleteBrand(int brandId)
	{
		brandDAOImpl.deleteBrand(brandId);
	}
	
	public Brand getBrandByName(String brandName)
	{
		return brandDAOImpl.getBrandByName(brandName);
	}
	
	public String getJsonBrandList()
	{
		return brandDAOImpl.getJsonBrandList();
	}
}
