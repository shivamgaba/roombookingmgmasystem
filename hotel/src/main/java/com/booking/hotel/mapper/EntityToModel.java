package com.booking.hotel.mapper;

import java.util.Optional;

import com.booking.hotel.entity.CustomerEntity;
import com.booking.hotel.model.Customer;
import com.booking.hotel.model.Customer.CustomerBuilder;

public class EntityToModel {

	public Customer mapModel(CustomerEntity entity) {

		Customer.CustomerBuilder builder = new CustomerBuilder();
		Optional.ofNullable(entity).map(CustomerEntity::getId).ifPresent(builder::setId);
		Optional.ofNullable(entity).map(CustomerEntity::getFirstName).ifPresent(builder::setFirstName);
		Optional.ofNullable(entity).map(CustomerEntity::getLastName).ifPresent(builder::setLastName);
		Optional.ofNullable(entity).map(CustomerEntity::getDob).ifPresent(builder::setDob);
		Optional.ofNullable(entity).map(CustomerEntity::getEmail).ifPresent(builder::setEmail);
		Optional.ofNullable(entity).map(CustomerEntity::getPassword).ifPresent(builder::setPassword);

		return builder.build();
	}
}
