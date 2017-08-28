package com.jwt.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.OrderDAO;
import com.jwt.model.OrderDetails;

@Service
public class OrderServiceImpl implements OrderService {
	private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	OrderDAO orderDao;

	@Override
	@Transactional
	public int addOrderDetails(int userId, float amount, Date dueDate) {
		OrderDetails order = new OrderDetails();
		order.setUserId(userId);
		order.setAmount(amount);
		order.setDate(dueDate);
		int orderId = orderDao.addOrderDetails(order);
		log.debug("Adding order id :: " + orderId + " for user ::" + userId);
		return orderId;
	}
	

}
