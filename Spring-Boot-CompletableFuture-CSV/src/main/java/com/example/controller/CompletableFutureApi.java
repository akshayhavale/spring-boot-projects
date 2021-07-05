package com.example.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.Person;
import com.example.services.PersonService;

@RestController
@RequestMapping("/api/v1")
public class CompletableFutureApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(CompletableFutureApi.class);

	@Autowired
	private PersonService personService;

	@Transactional
	@PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public @ResponseBody ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {

		try {
			CompletableFuture<List<Person>> persons = personService.savePersons(file.getInputStream());
			return new ResponseEntity<>(persons, HttpStatus.CREATED);
		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Transactional
	@PostMapping(path = "/normal/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public @ResponseBody ResponseEntity<?> uploadNormalWayFile(@RequestParam("file") MultipartFile file) {

		try {
			List<Person> persons = personService.savePersonsNormalWay(file.getInputStream());
			return new ResponseEntity<>(persons, HttpStatus.CREATED);
		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(path = "/persons", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CompletableFuture<ResponseEntity<?>> getAllPersons() {

		return personService.getAllPersons().<ResponseEntity<?>>thenApply(ResponseEntity::ok)
				.exceptionally(handleGetPersonFailure);

	}

	private static Function<Throwable, ResponseEntity<? extends List<Person>>> handleGetPersonFailure = throwable -> {
		LOGGER.error("Failed to read records: {}", throwable);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	};

}
