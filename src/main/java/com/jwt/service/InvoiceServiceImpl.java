package com.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.InvoiceDAO;
import com.jwt.model.Invoice;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	InvoiceDAO invoiceDao;
	
	@Override
	@Transactional
	public void addInvoice(int orderId, String productDesc, float rate) {
		Invoice invoice=new Invoice();
		invoice.setOrderId(orderId);
		invoice.setProductDesc(productDesc);
		invoice.setRate(rate);
		invoiceDao.addInvoice(invoice);
		
	}

}
