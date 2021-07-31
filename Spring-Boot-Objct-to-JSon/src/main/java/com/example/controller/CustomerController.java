package com.example.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.authenticator.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Customer;
import com.example.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

@RestController
public class CustomerController {
	
	
	@Autowired
	private ResourceLoader resourceLoader;

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		List<Customer> customers = customerService.getAllCustomer();
		ObjectMapper mapper = new ObjectMapper();
		try {
			/**
			 * Java Object to Json
			 */
			String json = mapper.writeValueAsString(customers);
			System.out.println(json);

			System.out.println("*****************************************************");
			
			/**
			 * json to Java Objects
			 */
			CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Customer.class);
			
			List<Customer> custs = mapper.readValue(json, listType);
			System.out.println(custs);
			
			System.out.println("*****************************************************");
			/**
			 * JsonFile to javaObject
			 */
			/**
			 * File file = new ClassPathResource("data/data.json").getFile();
			 */
			Resource resource=resourceLoader.getResource("classpath:customers.json");
			File file = resource.getFile();
			List<Customer> c = mapper.readValue(file, listType);
			System.out.println(c);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
	}

}
