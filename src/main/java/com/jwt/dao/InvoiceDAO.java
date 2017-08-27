package com.jwt.dao;

import com.jwt.model.Invoice;

public interface InvoiceDAO {
	
	int addInvoice(/*int orderId, String productDesc, float rate, int quantity*/Invoice invoice);

}
