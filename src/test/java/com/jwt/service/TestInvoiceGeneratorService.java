package com.jwt.service;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.BeforeClass;
import org.junit.Test;


@RunWith(PowerMockRunner.class)
@PrepareForTest(TestInvoiceGeneratorService.class)
public class TestInvoiceGeneratorService {
	
	@Mock
	private UserService userService;

	@Mock
	private OrderService orderService;
	
	@Mock
	private InvoiceService invoiceservice;
	
	@InjectMocks
	private InvoiceGeneratorServiceImpl invoiceGeneratorServiceImpl = new InvoiceGeneratorServiceImpl();
	
	@BeforeClass
	private void init() {

	}	


	@Test
	public void testAddInvoiceRecord(){


	}

}
