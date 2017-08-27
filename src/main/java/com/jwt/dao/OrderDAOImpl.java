package com.jwt.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addOrderDetails(Order order) {
		sessionFactory.getCurrentSession().save(order);
		return order.getId();
	}
}
