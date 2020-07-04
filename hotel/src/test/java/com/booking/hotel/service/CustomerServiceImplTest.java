package com.booking.hotel.service;

import java.util.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.booking.hotel.entity.CustomerEntity;
import com.booking.hotel.error.PasswordConstraintException;
import com.booking.hotel.error.UserNotFoundException;
import com.booking.hotel.error.UsernameAlreadyExists;
import com.booking.hotel.model.Customer;
import com.booking.hotel.model.Customer.CustomerBuilder;
import com.booking.hotel.repository.CustomerRepository;

public class CustomerServiceImplTest {

	@InjectMocks
	CustomerServiceImpl customerServiceImpl;

	@Mock
	private CustomerRepository repo;

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSave() {
		customerServiceImpl.save(buildCustomer());
	}

	@Test
	public void testSaveInvalidEmail() {
		Mockito.when(repo.findByEmail(Mockito.anyString())).thenReturn(buildEntity());
		exception.expect(UsernameAlreadyExists.class);
		customerServiceImpl.save(buildCustomer());
	}

	@Test
	public void testSaveWithInvaildPasswordLengthLessThen8() {
		Customer.CustomerBuilder builder = new CustomerBuilder();
		builder.setPassword("sgh");
		exception.expect(PasswordConstraintException.class);
		customerServiceImpl.save(builder.build());
	}

	@Test
	public void testSaveWithInvaildPasswordLengthMoreThen10() {
		Customer.CustomerBuilder builder = new CustomerBuilder();
		builder.setPassword("sghiushfissaf");
		exception.expect(PasswordConstraintException.class);
		customerServiceImpl.save(builder.build());
	}

	@Test
	public void testGetById() {
		Mockito.when(repo.findById(Mockito.anyLong())).thenReturn(buildEntity());
		customerServiceImpl.getById(1L);
	}

	@Test
	public void testIdNotFoundException() {
		exception.expect(UserNotFoundException.class);
		customerServiceImpl.getById(1L);
	}

	private Customer buildCustomer() {
		Customer.CustomerBuilder builder = new CustomerBuilder();
		builder.setFirstName("shivam").setLastName("gaba").setId(1L).setDob(new Date()).setEmail("sh@gmail.com")
				.setPassword("sghdfdgfg");
		return builder.build();
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
