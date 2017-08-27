package com.jwt.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.Invoice;

@Repository
public class InvoiceDAOImpl implements InvoiceDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int addInvoice(Invoice invoice) {
		sessionFactory.getCurrentSession().save(invoice);
		return invoice.getId();
	}

}
