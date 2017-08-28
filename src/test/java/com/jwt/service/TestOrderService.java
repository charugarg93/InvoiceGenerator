package com.jwt.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.jwt.dao.OrderDAO;
import com.jwt.model.OrderDetails;


public class TestOrderService {


	@Mock
	private OrderDAO orderDao;

	@Mock
	private OrderDetails order;

	@InjectMocks
	private OrderServiceImpl orderService = new OrderServiceImpl();


	public Date dateCreation() throws ParseException {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = " 2014-02-11";
		Date dateObject = sdf.parse(dateString); 
		return dateObject;

	}

	@Before
	public void setupMock() throws ParseException {
		order = mock(OrderDetails.class);
		orderDao = mock(OrderDAO.class);
		order.setUserId(1);
		order.setAmount((float) 100.0);
		order.setDate(dateCreation());
	}

	@Test
	public void setUpMock() throws ParseException {

		orderDao.addOrderDetails(order);
		assertEquals(0,order.getId());
		assertEquals(0, order.getAmount(), 0);

	}



	@Test
	public void testMockCreation(){
		assertNotNull(order);
		assertNotNull(orderDao);
	}

}
