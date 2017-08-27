package com.jwt.service;

public interface InvoiceService {
	void addInvoice(int orderId, String productDesc, float rate, int quantity);
}
