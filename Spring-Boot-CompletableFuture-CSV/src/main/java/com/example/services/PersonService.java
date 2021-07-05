package com.example.services;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.example.model.Person;

@Service
public interface PersonService {

	CompletableFuture<List<Person>> savePersons(final InputStream inputStream) throws Exception;

	CompletableFuture<List<Person>> getAllPersons();

	List<Person> savePersonsNormalWay(final InputStream inputStream) throws Exception;
}
