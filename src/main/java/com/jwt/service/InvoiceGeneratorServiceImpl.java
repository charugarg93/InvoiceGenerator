package com.jwt.service;

import java.util.Date;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.exception.InvoiceGeneratorInternalException;
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
	ProductsInOrderService invoiceService;

	@Override
	@Transactional
	public void addInvoiceRecord(InvoiceFormEntity invoiceForm) throws InvoiceGeneratorInternalException{
		User user = invoiceForm.getUser();
		if(user==null){
			log.error("User is null from Invoice Form ::"+ invoiceForm);
			throw new InvoiceGeneratorInternalException("ER1", "Internal Exception, please try later");
		}
		List<User> userList = userService.getUserByEmail(user.getEmail());
		float amount = invoiceForm.getTotalAmount();
		int userId = (userList != null && userList.size() > 0) ? userList.get(0).getId() : userService.saveUser(user);
		int orderId = orderService.addOrderDetails(userId, amount, invoiceForm.getDueDate());
		if(invoiceForm.getProducts()==null){
			log.error("No products to be added ::"+ invoiceForm);
			throw new InvoiceGeneratorInternalException("ER2", "No products were provided");
		}
		for (ProductDetail product : invoiceForm.getProducts()) {
			invoiceService.addInvoice(orderId, product.getDescription(), product.getAmount());
		}
		log.info("Invoice generated for user:: " + userId + ", with order id::" + orderId);
		log.debug("successful insert:" + user.getEmail());
	}

	}
