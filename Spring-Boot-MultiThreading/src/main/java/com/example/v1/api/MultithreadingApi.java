package com.example.v1.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.v1.dto.Information;
import com.example.v1.services.PrimeNumberService;
import com.example.v1.util.MyCallable;
import com.example.v1.utils.Algorithms;
import com.example.v1.utils.MessageMimicService;

@RestController
public class MultithreadingApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(MultithreadingApi.class);

	@Autowired
	private Algorithms algorithms;

	@Autowired
	private MessageMimicService messageMimicService;

	@Autowired
	private PrimeNumberService primeNumberService;

	@GetMapping("/test/primeNumber/{num}")
	public @ResponseBody Information test(@PathVariable("num") Long num) {

		System.out.println("ENTERED METHOD");

		final long statTime = System.currentTimeMillis();
//		final int number = Math.abs(new Random().nextInt());
		final long number = num;
		final String threadName = Thread.currentThread().getName();
		boolean result = algorithms.isPrimeNumber(num);
		final long endTime = System.currentTimeMillis();
		final long timeTaken = endTime - statTime;

		Information info = new Information();
		info.setRandomNumber(number);
		info.setResult(result);
		info.setThreadName(threadName);
		info.setTimeTaken(timeTaken);
		return info;

	}

	@GetMapping("/test/primeNumber/multi")
	public @ResponseBody List<Information> testMultithreading() throws InterruptedException, ExecutionException {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
//		final long statTime = System.currentTimeMillis();

		List<Information> list = new ArrayList<>();
		for (int i = 1; i < 11; i++) {
			final int number = Math.abs(new Random().nextInt());

			Future<Information> result = newFixedThreadPool.submit(new MyCallable(number));
			list.add(result.get());
		}

		return list;

	}

	@PostMapping("/sendMessage")
	public String sendMessage(@RequestParam(value = "message", required = true) String message)
			throws InterruptedException {

		messageMimicService.sendMessage(message);

		return "SUCCESS";

	}

	@GetMapping("/test/primeNumber/multi1")
	public @ResponseBody CompletableFuture<ResponseEntity<?>> testMultithreading1()
			throws InterruptedException, ExecutionException {
//		final int number1 = Math.abs(new Random().nextInt());
//		final int number2 = Math.abs(new Random().nextInt());
		final int number1 = 345329091;
		final int number2 = 1194836473;
		LOGGER.info("the number1 : {}", number1);
		LOGGER.info("the number2 : {}", number2);
		List<Integer> numbers = Arrays.asList(number1, number2);
		LOGGER.info("Current Time : {}", System.currentTimeMillis() * 1000);
		return primeNumberService.varifyPrimeNumber(numbers).thenApply(ResponseEntity::ok);

	}

	@GetMapping("/test/primeNumber/normal")
	public @ResponseBody List<Boolean> testNormal1()
			throws InterruptedException, ExecutionException {
//		final int number1 = Math.abs(new Random().nextInt());
//		final int number2 = Math.abs(new Random().nextInt());
		final int number1 = 345329091;
		final int number2 = 1194836473;
		LOGGER.info("the number1 : {}", number1);
		LOGGER.info("the number2 : {}", number2);
		List<Integer> numbers = Arrays.asList(number1, number2);
		LOGGER.info("Current Time : {}", System.currentTimeMillis() * 1000);
		return primeNumberService.varifyPrimeNumberNoraml(numbers);

	}
}
