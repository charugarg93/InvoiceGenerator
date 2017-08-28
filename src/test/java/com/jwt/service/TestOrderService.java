package com.jwt.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.jwt.dao.OrderDAO;
import com.jwt.model.Order;

public class TestOrderService {


	@Mock
	private OrderDAO orderDao;


	@InjectMocks
	private OrderServiceImpl orderService = new OrderServiceImpl();
	
	@InjectMocks
	private Order order = new Order();
	
	public Date dateCreation() throws ParseException {
	DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String dateString = " 2014-02-11";
	Date dateObject = sdf.parse(dateString); 
	return dateObject;
	
	}
	
	@Before
	public void setUpMock() throws ParseException {
		order.setUserId(1);
		order.setAmount((float) 100.0);
		order.setDate(dateCreation());
		when(orderDao.addOrderDetails(order)).thenReturn(10);
		
	}
	
	@Test
	public void testAddOrderDetails() throws ParseException {
		
		
		when(orderService.addOrderDetails(order.getId(),order.getAmount(), order.getDate())).thenReturn(9);
		assertEquals(9, orderService.addOrderDetails(1, (float) 100.00, dateCreation()));
	}
}
