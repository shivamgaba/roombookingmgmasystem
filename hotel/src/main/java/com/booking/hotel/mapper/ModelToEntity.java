package com.booking.hotel.mapper;

import java.util.Optional;

import org.springframework.util.Assert;

import com.booking.hotel.entity.CustomerEntity;
import com.booking.hotel.model.Customer;

public class ModelToEntity {

	public CustomerEntity mapEntity(Customer customer) {
		Assert.notNull(customer, "customer object can not be empty");
		CustomerEntity customerEntity = new CustomerEntity();

		Optional.ofNullable(customer).map(Customer::getFirstName).ifPresent(customerEntity::setFirstName);
		Optional.ofNullable(customer).map(Customer::getLastName).ifPresent(customerEntity::setLastName);
		Optional.ofNullable(customer).map(Customer::getDob).ifPresent(customerEntity::setDob);
		Optional.ofNullable(customer).map(Customer::getEmail).ifPresent(customerEntity::setEmail);
		Optional.ofNullable(customer).map(Customer::getPassword).ifPresent(customerEntity::setPassword);
		return customerEntity;
	}
}
