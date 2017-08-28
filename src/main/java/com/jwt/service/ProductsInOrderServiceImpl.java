package com.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.InvoiceDAO;
import com.jwt.model.ProductsInOrder;

@Service
public class ProductsInOrderServiceImpl implements ProductsInOrderService {

	@Autowired
	InvoiceDAO invoiceDao;
	
	@Override
	@Transactional
	public void addInvoice(int orderId, String productDesc, float rate) {
		ProductsInOrder invoice=new ProductsInOrder();
		invoice.setOrderId(orderId);
		invoice.setProductDesc(productDesc);
		invoice.setRate(rate);
		invoiceDao.addInvoice(invoice);
		
	}

}
