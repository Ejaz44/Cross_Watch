package com.watches.crosswatch.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.watches.crosswatch.model.Supplier;
import com.watches.crosswatch.service.SupplierService;

@Controller
public class SupplierController 
{
	@Autowired
	SupplierService supplierService;
	
	@RequestMapping("/Supplier")
	public String supplier(Model model)
	{
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("supplierList", supplierService.getJsonSupplierList());
		return "/Supplier";
	}
	
	@RequestMapping("/addSupplier")
	public String addSupplier(@Valid  @ModelAttribute("supplier") Supplier supplier, BindingResult bindingResult, Model model )
	{
		if(bindingResult.hasErrors())
		{
			model.addAttribute("supplierList", supplierService.getJsonSupplierList());
			return "/Supplier";
		}
		else
		{
		supplierService.addSupplier(supplier);
		return "redirect:/Supplier";
		}
	}
	
	@RequestMapping("/editSupplier-{supplierId}")
	public String editSupplier(Model model, @PathVariable("supplierId") int supplierId)
	{
		model.addAttribute("supplier", supplierService.getListById(supplierId));
		return "Supplier";
	}
	
	@RequestMapping("/deleteSupplier-{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId") int supplierId)
	{
		supplierService.deleteSupplier(supplierId);
		return "redirect:/Supplier";
	}
	
	public String getJsonSupplierList()
	{
		return supplierService.getJsonSupplierList();
	}
}