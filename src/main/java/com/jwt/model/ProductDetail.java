package com.jwt.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Size(min = 2, max = 50, message = "Please provide proper description")
	@NotNull(message = "Please provide proper description")
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
