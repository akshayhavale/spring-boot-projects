package com.example.controller;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.CustomerDao;
import com.example.model.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class CustomerApi {

	@Autowired
	private CustomerDao customerDao;

	@PostMapping("/customers")
	public @ResponseBody Mono<Customer> saveCustomer(@RequestBody Mono<Customer> customer) {
		return customerDao.saveCustomer(customer);
	}

	@GetMapping("/customers")
	public @ResponseBody Flux<Customer> getAll() {
		return customerDao.getALl();
	}

}
