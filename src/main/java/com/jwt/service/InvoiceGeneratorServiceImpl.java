package com.jwt.service;

import java.util.Date;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.jwt.model.User;

public class InvoiceGeneratorServiceImpl implements InvoiceGeneratorService {

	private static final Logger log = Logger.getLogger(InvoiceGeneratorServiceImpl.class);

	@Autowired
	UserService userService;

	@Autowired
	OrderService orderService;
	
	@Autowired
	InvoiceService invoiceservice;

	@Override
	public void addInvoiceRecord(User user) {
		List<User> userList = userService.getUserByEmail(user.getEmail());
		int amount = 0;// TODO: get Amount, date
		int userId = (userList != null && userList.size() > 0) ? userList.get(0).getId() : userService.saveUser(user);
		int orderId = orderService.addOrderDetails(userId, amount, new Date());
		//TODO : uncomment
		//invoiceservice.addInvoice(orderId, productDesc, rate, quantity);
		log.info("successful insert:" + user.getEmail());
	}

}
