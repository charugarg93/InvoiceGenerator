package com.jwt.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.OrderDAO;
import com.jwt.model.Order;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDAO orderDao;

	@Override
	@Transactional
	public int addOrderDetails(int userId, float amount, Date dueDate) {
		Order order = new Order();
		order.setUserId(userId);
		order.setAmount(amount);
		order.setDate(dueDate);
		return orderDao.addOrderDetails(order);
	}

}
