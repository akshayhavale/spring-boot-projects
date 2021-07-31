package com.example.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Customer;

@Service
public class CustomerService {

	public List<Customer> getAllCustomer() {

		return Arrays.asList(new Customer(1L, "Akshay", "7787986654"), new Customer(1L, "Mahesh", "9866756777"));

	}

	public Customer getCustomer() {
		return new Customer(1L, "Akshay", "7787986654");
	}
}
