package com.booking.hotel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.hotel.model.Customer;
import com.booking.hotel.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	private CustomerService service;

	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@PostMapping(value = "/customer", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> saveCustomer(@Valid @RequestBody Customer customer) {
		service.save(customer);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping(value = "/customer/{id}", produces = "application/json")
	public ResponseEntity<?> getCustomerById(@PathVariable(value = "id") Long id) {
		Customer customer = service.getById(id);
		return new ResponseEntity<>(customer, HttpStatus.OK);

	}
}
