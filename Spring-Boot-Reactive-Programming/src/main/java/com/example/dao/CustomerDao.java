package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.model.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CustomerDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDao.class);

	private List<Customer> customers = new ArrayList<>();

	

	public Mono<Customer> saveCustomer(Mono<Customer> customer) {
		
		

		LOGGER.info("save method entered ");

		Mono<Customer> doOnNext = customer.doOnNext(this::saveInList);

		LOGGER.info("Customer Is Saved ");
		String name = doOnNext.block().getFirstname();
		LOGGER.info("Customer saved name : {}", name);

		LOGGER.info("Saved Customer Name is : {}", name);
		return doOnNext;

	}

	public Flux<Customer> getALl() {
		LOGGER.info("Get all Customers entered");
		Flux<Customer> flux = Flux.fromIterable(customers);
		List<String> names = new ArrayList<>();

		LOGGER.info("Check doOnNext what it do");
		flux.subscribe(cust -> names.add(cust.getFirstname()));
		LOGGER.info("NAMES AS ARE :{}", names);

		return flux;
	}

	private void saveInList(Customer customer) {
		customers.add(customer);
	}

	private void print(List<String> name) {

		LOGGER.info("NAME IS : {}", name);

	}

}
