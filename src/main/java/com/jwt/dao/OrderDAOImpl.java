package com.jwt.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.OrderDetails;


@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addOrderDetails(OrderDetails order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);
		return order.getId();
	}
}
