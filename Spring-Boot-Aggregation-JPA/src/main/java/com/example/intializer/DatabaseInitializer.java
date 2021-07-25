package com.example.intializer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.Address;
import com.example.model.Person;
import com.example.repository.PersonRepository;

@Component
public class DatabaseInitializer {

	@Autowired
	private PersonRepository personRepository;

	@PostConstruct
	public void intialize() {

		Person person = new Person();
		person.setFirstname("Akshay");
		person.setLastname("Havale");
		Address address = new Address();
		address.setLine1("#19, Maruthi Nilaya");
		address.setLine2("Shivagiri colony");
		address.setStreet("UdayaNagar");
		address.setCity("Hubli");
		address.setState("Karnataka");
		address.setZipcode("580023");
		person.setAddress(address);
		personRepository.save(person);
	}

}
