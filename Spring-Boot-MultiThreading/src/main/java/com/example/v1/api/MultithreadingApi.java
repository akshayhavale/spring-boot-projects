package com.example.v1.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.v1.dto.Information;
import com.example.v1.util.MyCallable;
import com.example.v1.utils.Algorithms;
import com.example.v1.utils.MessageMimicService;

@RestController
public class MultithreadingApi {

	@Autowired
	private Algorithms algorithms;

	@Autowired
	private MessageMimicService messageMimicService;

	@GetMapping("/test/primeNumber/{num}")
	public @ResponseBody Information test(@PathVariable("num") Long num) {

		System.out.println("ENTERED METHOD");

		final long statTime = System.currentTimeMillis();
//		final int number = Math.abs(new Random().nextInt());
		final long number = num;
		final String threadName = Thread.currentThread().getName();
		boolean result = algorithms.isPrimeNumber(number);
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

}
