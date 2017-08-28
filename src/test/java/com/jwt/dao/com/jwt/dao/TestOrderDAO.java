package com.jwt.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.jwt.dao.OrderDAO;
import com.jwt.model.OrderDetails;

public class TestOrderDAO {

	@Mock
	private OrderDAO orderDao;

	@Mock
	private OrderDetails orderDetails;
	

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSaveOrder() {
		
		when(orderDao.addOrderDetails(orderDetails)).thenReturn(5);
		assertEquals(5, orderDao.addOrderDetails(orderDetails));

	}
	
	@Test
	public void testMockCreationOfOrderDao(){
		assertNotNull(orderDao);
		assertNotNull(orderDetails);
	}
	

}
