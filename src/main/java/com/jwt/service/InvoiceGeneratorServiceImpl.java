package com.jwt.service;

import java.util.Date;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.model.InvoiceFormEntity;
import com.jwt.model.ProductDetail;
import com.jwt.model.User;

@Service
public class InvoiceGeneratorServiceImpl implements InvoiceGeneratorService {

	private static final Logger log = Logger.getLogger(InvoiceGeneratorServiceImpl.class);

	@Autowired
	UserService userService;

	@Autowired
	OrderService orderService;

	@Autowired
	InvoiceService invoiceService;

	@Override
	@Transactional
	public void addInvoiceRecord(InvoiceFormEntity invoiceForm) {
		User user = invoiceForm.getUser();
		List<User> userList = userService.getUserByEmail(user.getEmail());
		float amount = invoiceForm.getTotalAmount();// TODO: get Amount, date
		int userId = (userList != null && userList.size() > 0) ? userList.get(0).getId() : userService.saveUser(user);
		int orderId = orderService.addOrderDetails(userId, amount, invoiceForm.getDueDate());
		for (ProductDetail product : invoiceForm.getProducts()) {
			invoiceService.addInvoice(orderId, product.getDescription(), product.getAmount());
		}
		log.info("successful insert:" + user.getEmail());
	}

	}
