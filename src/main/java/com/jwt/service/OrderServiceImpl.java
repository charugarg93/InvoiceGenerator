package com.jwt.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.jwt.dao.OrderDAO;
import com.jwt.model.Order;

public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDAO orderDao;

	@Override
	public int addOrderDetails(int userId, float amount, Date dueDate) {
		Order order = new Order();
		order.setUserId(userId);
		order.setAmount(amount);
		order.setDate(dueDate);
		return orderDao.addOrderDetails(order);
	}

}
