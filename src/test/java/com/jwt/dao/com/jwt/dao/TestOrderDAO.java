package com.jwt.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.jwt.dao.OrderDAO;
import com.jwt.model.Order;

public class TestOrderDAO {

	@Mock
	private OrderDAO orderDao;
	@Mock
	private Order order;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSaveOrder() {
		when(orderDao.addOrderDetails(order)).thenReturn(5); 
		assertEquals(5, orderDao.addOrderDetails(order));
	}
	
	@Test
	public void testMockCreationOfOrderDao(){
		assertNotNull(order);
		assertNotNull(orderDao);
	}
}
