package com.booking.hotel.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.hotel.entity.CustomerEntity;
import com.booking.hotel.error.PasswordConstraintException;
import com.booking.hotel.error.UserNotFoundException;
import com.booking.hotel.error.UsernameAlreadyExists;
import com.booking.hotel.mapper.EntityToModel;
import com.booking.hotel.mapper.ModelToEntity;
import com.booking.hotel.model.Customer;
import com.booking.hotel.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository repo;

	@Autowired
	public CustomerServiceImpl(CustomerRepository repo) {
		this.repo = repo;
	}

	@Override
	public void save(Customer customer) {
		Optional<CustomerEntity> entity = repo.findByEmail(customer.getEmail());
		if (entity.isPresent()) {
			throw new UsernameAlreadyExists("Your email is already registered with us.");
		}
		if (customer.getPassword().length() < 8 || customer.getPassword().length() > 10) {
			throw new PasswordConstraintException(
					"Password should be minimum of 8 characters and maximum of 10 characters.");
		}

		ModelToEntity mtoe = new ModelToEntity();
		CustomerEntity customerEntity = mtoe.mapEntity(customer);
		repo.save(customerEntity);
	}

	@Override
	public Customer getById(Long id) {
		EntityToModel etom = new EntityToModel();
		Optional<CustomerEntity> entity = repo.findById(id);
		if (entity.isPresent()) {
			Customer customer = etom.mapModel(entity.get());
			return customer;
		} else {
			throw new UserNotFoundException("User with id: " + id + " is not found");
		}
	}

}
