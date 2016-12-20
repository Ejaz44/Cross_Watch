package com.watches.crosswatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.watches.crosswatch.model.Category;
import com.watches.crosswatch.model.SubCategory;
import com.watches.crosswatch.service.CategoryService;
import com.watches.crosswatch.service.SubCategoryService;

@Controller
public class SubCategoryController 
{
	@Autowired
	SubCategoryService subCategoryService;
	@Autowired 
	CategoryService categoryService;
	
	@RequestMapping("/SubCategory")
	public String subCategory(Model model)
	{
		model.addAttribute("category", new Category());
		model.addAttribute("subCategory", new SubCategory());
		model.addAttribute("categoryList", categoryService.getList());
		model.addAttribute("subCategoryList", subCategoryService.getJsonSubCategoryList());
		return "/SubCategory";
	}
	
	@RequestMapping("/addSubCategory")
	public String addSubCategory(@ModelAttribute("subCategory") SubCategory subCategory)
	{
		Category category = categoryService.getCategoryByName(subCategory.getCategory().getCategoryName());
		subCategory.setCategory(category);
		subCategory.setCategoryId(category.getCategoryId());
		subCategoryService.addSubCategory(subCategory);
		return "redirect:/SubCategory";
	}
	
	@RequestMapping("/editSubCategory-{subCategoryId}")
	public String editSubCategory(Model model, @PathVariable("subCategoryId") int subCategoryId)
	{
		model.addAttribute("subCategory", subCategoryService.getListById(subCategoryId));
		model.addAttribute("categoryList", categoryService.getList());
		return "/SubCategory";
	}
	
	@RequestMapping("/deleteSubCategory-{subCategoryId}")
	public String deleteSubCategory(@PathVariable("subCategoryId") int subCategoryId)
	{
		subCategoryService.deleteSubCategory(subCategoryId);
		return "redirect:/SubCategory";
	}	
	
	
}