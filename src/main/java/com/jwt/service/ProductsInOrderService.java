package com.jwt.service;

public interface ProductsInOrderService {
	void addInvoice(int orderId, String productDesc, float rate);
}
