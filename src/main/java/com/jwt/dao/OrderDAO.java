package com.jwt.dao;

import com.jwt.model.Order;

public interface OrderDAO {
	int addOrderDetails(Order order);
}