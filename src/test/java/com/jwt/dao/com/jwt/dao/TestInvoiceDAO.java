package com.jwt.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.jwt.model.ProductsInOrder;


public class TestInvoiceDAO {
	
	@Mock
	private InvoiceDAO invoiceDao;
	@Mock
	private ProductsInOrder invoice;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testMockCreationOfUserDao(){
		assertNotNull(invoice);
		assertNotNull(invoiceDao);
	}
}
