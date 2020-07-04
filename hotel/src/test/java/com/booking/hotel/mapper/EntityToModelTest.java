package com.booking.hotel.mapper;

import java.util.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.booking.hotel.entity.CustomerEntity;

public class EntityToModelTest {

	@InjectMocks
	EntityToModel etom;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testmapModel() {
		etom.mapModel(buildEntity().get());
	}

	private Optional<CustomerEntity> buildEntity() {
		CustomerEntity entity = new CustomerEntity();
		entity.setId(1L);
		entity.setFirstName("shivam");
		entity.setLastName("gaba");
		entity.setDob(new Date());
		entity.setEmail("sh@gmail.com");
		entity.setPassword("sghdfdgfg");
		return Optional.of(entity);
	}
}
