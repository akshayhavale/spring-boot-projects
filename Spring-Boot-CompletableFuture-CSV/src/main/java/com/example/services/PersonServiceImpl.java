package com.example.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.model.Person;
import com.example.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);

	@Autowired
	private PersonRepository personRepository;

	@Async
	@Override
	public CompletableFuture<List<Person>> savePersons(InputStream inputStream) throws Exception {

		final long start = System.currentTimeMillis();

		List<Person> persons = parseCSVFile(inputStream);

		LOGGER.info("Saving a list of persons of size {} records", persons.size());

//		final int totalObjects = persons.size();
//		final int batchSize = 4000;
//		for (int i = 0; i < totalObjects; i = i + batchSize) {
//
//			if (i + batchSize > totalObjects) {
//
//				List<Person> books1 = persons.subList(i, totalObjects - 1);
//
//				personRepository.saveAll(books1);
//
//				break;
//
//			}
//
//			List<Person> books1 = persons.subList(i, i + batchSize);
//
//			personRepository.saveAll(books1);
//		}
		 persons = personRepository.saveAll(persons);

		LOGGER.info("Elapsed time : {}", (System.currentTimeMillis() - start));

		return CompletableFuture.completedFuture(persons);
	}

	@Async
	@Override
	public CompletableFuture<List<Person>> getAllPersons() {
		LOGGER.info("REQUESTED FOR ALL PERSONS");

		final List<Person> persons = personRepository.findAll();

		return CompletableFuture.completedFuture(persons);
	}

	private List<Person> parseCSVFile(final InputStream inputStream) throws Exception {

		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			List<Person> persons = new ArrayList<>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				final Person person = new Person();

				person.setFirstname(csvRecord.get("name/first"));
				person.setLastname(csvRecord.get("name/last"));
				person.setAge(Integer.parseInt(csvRecord.get("age")));
				person.setStreet(csvRecord.get("street"));
				person.setCity(csvRecord.get("city"));
				person.setState(csvRecord.get("state"));
				person.setZip(csvRecord.get("zip"));
				person.setDate(new Date(csvRecord.get("date")));

				persons.add(person);
			}

			return persons;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}

	@Override
	public List<Person> savePersonsNormalWay(InputStream inputStream) throws Exception {

		final long start = System.currentTimeMillis();

		List<Person> persons = parseCSVFile(inputStream);

		LOGGER.info("Saving a list of persons of size {} records", persons.size());

		persons = personRepository.saveAll(persons);

		LOGGER.info("Elapsed time : {}", (System.currentTimeMillis() - start));

		return persons;
	}
}
