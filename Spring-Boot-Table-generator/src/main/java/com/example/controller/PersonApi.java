package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Person;
import com.example.repository.PersonRepository;

@RestController
@RequestMapping("/api/v1")
public class PersonApi {

	@Autowired
	private PersonRepository personRepository;

	@PostMapping("/person")
	public @ResponseBody ResponseEntity<?> savePerson(@RequestBody Person person) {

		Person savedPerson = personRepository.save(person);

		return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
	}

	@GetMapping("/persons")
	public @ResponseBody ResponseEntity<?> getAllPerson() {

		List<Person> persons = personRepository.findAll();

		return new ResponseEntity<>(persons, HttpStatus.OK);

	}

}
