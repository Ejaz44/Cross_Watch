package com.watches.crosswatch.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.ui.Model;

@Entity
public class Category 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	@NotEmpty(message = "Please enter CategoryName")
	@Pattern(regexp ="([a-zA-Z]{1})+[a-zA-Z0-9]+", message = "Enter valid Category Name")
	private String categoryName;
	@NotEmpty(message = "please enter categoryDescription")
	@Pattern(regexp ="([a-zA-Z]{1})+[a-zA-Z0-9]+", message = "Enter valid category description")
	private String categoryDescription;
	
	public int getCategoryId() 
	{
		return categoryId;
	}
	
	public void setCategoryId(int categoryId) 
	{
		this.categoryId = categoryId;
	}
	
	public String getCategoryName() 
	{
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) 
	{
		this.categoryName = categoryName;
	}
	
	public String getCategoryDescription() 
	{
		return categoryDescription;
	}
	
	public void setCategoryDescription(String categoryDescription) 
	{
		this.categoryDescription = categoryDescription;
	}
}