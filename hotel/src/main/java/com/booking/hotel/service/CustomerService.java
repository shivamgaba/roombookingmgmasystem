package com.booking.hotel.service;

import com.booking.hotel.model.Customer;

public interface CustomerService {

	public void save(Customer customer);

	public Customer getById(Long id);
}
