package com.booking.hotel.controller;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.booking.hotel.model.Customer;
import com.booking.hotel.model.Customer.CustomerBuilder;
import com.booking.hotel.service.CustomerService;

public class CustomerControllerTest {

	@InjectMocks
	CustomerController customerController;

	@Mock
	private CustomerService service;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		//customerController = new CustomerController(service);
		//this.service = Mockito.mock(CustomerService.class);
	}

	@Test
	public void testSaveCustomer() {
		customerController.saveCustomer(buildCustomer());
	}

	@Test
	public void testGetCustomerById() {
		Mockito.when(service.getById(Mockito.anyLong())).thenReturn(buildCustomer());
		customerController.getCustomerById(1L);
	}

	private Customer buildCustomer() {
		Customer.CustomerBuilder builder = new CustomerBuilder();
		builder.setFirstName("shivam").setLastName("gaba").setId(1L).setDob(new Date()).setEmail("sh@gmail.com")
				.setPassword("sghdfdgfg");
		return builder.build();
	}
}
