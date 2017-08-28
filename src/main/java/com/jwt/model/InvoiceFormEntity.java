package com.jwt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class InvoiceFormEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private User user;
	private List<ProductDetail> products;
	private float totalAmount;
	private Date dueDate;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<ProductDetail> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDetail> products) {
		this.products = products;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	@Override
	public String toString() {
		return "InvoiceFormEntity [user=" + user + ", products=" + products + ", totalAmount=" + totalAmount
				+ ", dateDate=" + dueDate + "]";
	}
}
