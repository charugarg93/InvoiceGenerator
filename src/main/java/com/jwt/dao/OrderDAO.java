package com.jwt.dao;

import com.jwt.model.OrderDetails;

public interface OrderDAO {
	int addOrderDetails(OrderDetails order);
}