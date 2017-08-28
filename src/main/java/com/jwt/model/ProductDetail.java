package com.jwt.model;

import java.io.Serializable;

public class ProductDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String description;
	
	private float amount;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ProductDetail [description=" + description + ", amount=" + amount + "]";
	}
}
