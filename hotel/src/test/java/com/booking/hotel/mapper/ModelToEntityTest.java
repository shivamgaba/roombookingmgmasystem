package com.booking.hotel.mapper;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.booking.hotel.model.Customer;
import com.booking.hotel.model.Customer.CustomerBuilder;

public class ModelToEntityTest {

	@InjectMocks
	ModelToEntity mtoe;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testMapEntity() {
		mtoe.mapEntity(buildCustomer());
	}

	private Customer buildCustomer() {
		Customer.CustomerBuilder builder = new CustomerBuilder();
		builder.setFirstName("shivam").setLastName("gaba").setId(1L).setDob(new Date()).setEmail("sh@gmail.com")
				.setPassword("sghdfdgfg");
		return builder.build();
	}
}
