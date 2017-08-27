package com.jwt.service;

import java.util.Date;

public interface OrderService {
	int addOrderDetails(int userId, float amount, Date dueDate);

}
