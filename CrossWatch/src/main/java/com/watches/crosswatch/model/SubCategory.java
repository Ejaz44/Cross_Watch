package com.watches.crosswatch.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class SubCategory 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int subCategoryId;
	@NotEmpty
	@Pattern(regexp ="([a-zA-Z]{1})+[a-zA-Z0-9]+", message = "Enter valid subCategory Name")
	private String subCategoryName;
	@Pattern(regexp ="([a-zA-Z]{1})+[a-zA-Z0-9]+", message = "Enter valid subCategory description")
	private String subCategoryDescription;
	private int categoryId;
	
	@ManyToOne
	@JoinColumn(name="categoryId", updatable=false, insertable=false, nullable=false)
	private Category category;
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	public String getSubCategoryDescription() {
		return subCategoryDescription;
	}
	public void setSubCategoryDescription(String subCategoryDescription) {
		this.subCategoryDescription = subCategoryDescription;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}