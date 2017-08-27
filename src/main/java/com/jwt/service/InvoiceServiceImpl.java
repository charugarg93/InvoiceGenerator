package com.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.jwt.dao.InvoiceDAO;
import com.jwt.model.Invoice;

public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	InvoiceDAO invoiceDao;
	
	@Override
	public void addInvoice(int orderId, String productDesc, float rate, int quantity) {
		Invoice invoice=new Invoice();
		invoice.setOrderId(orderId);
		invoice.setProductDesc(productDesc);
		invoice.setRate(rate);
		invoice.setQuantity(quantity);
		invoiceDao.addInvoice(invoice);
		
	}

}
