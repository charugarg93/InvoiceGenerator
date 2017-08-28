package com.jwt.dao;

import com.jwt.model.ProductsInOrder;

public interface InvoiceDAO {
	
	int addInvoice(/*int orderId, String productDesc, float rate, int quantity*/ProductsInOrder invoice);
}
