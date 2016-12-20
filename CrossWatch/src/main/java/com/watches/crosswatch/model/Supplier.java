package com.watches.crosswatch.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Supplier 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int supplierId;
	@NotEmpty(message = "please enter the supplierName")
	@Pattern(regexp ="([a-zA-Z]{1})+[a-zA-Z0-9]+", message = "Enter valid Supplier Name")
	private String supplierName;
	@NotEmpty(message = "please enter the supplier address")
	@Pattern(regexp ="([a-zA-Z]{1})+[a-zA-Z0-9]+", message = "Enter valid Category Name")
	private String supplierAddress;
	@NotEmpty(message = "please enter the supplier email")
	@Pattern(regexp=".+@.+\\..+", message="Email Pattern is Incorrect")
	private String supplierEmail;
	
	
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	public String getSupplierEmail() {
		return supplierEmail;
	}
	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}
	
	
}
