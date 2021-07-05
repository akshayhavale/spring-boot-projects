package com.example.v1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class PrimeNumberServicesImpl implements PrimeNumberService {

	@Async
	@Override
	public CompletableFuture<List<Boolean>> varifyPrimeNumber(List<Integer> numbers) {
		List<Boolean> results = new ArrayList<Boolean>();
		numbers.stream().forEach(number -> {

			Boolean result = this.isPrimeNumber(number);
			results.add(result);

		});

		return CompletableFuture.completedFuture(results);

	}

	private boolean isPrimeNumber(long number) {

		System.out.println("ENTERD ALGORITHM");

		/**
		 * 
		 * Conditions to verify is boolean
		 * 
		 * 1) It should be greater than zero
		 * 
		 * 2) It should be only divide by itself and not by any other number except 1
		 * 
		 * Logic
		 * 
		 * 1) check number is greater than 1
		 * 
		 * 2) if number = 1 and 2 return its prime number
		 * 
		 * 3) More than 2 value of number then iterate from reverse side decreasing
		 * count of that number and check is divisible by using number%value==0
		 * 
		 * 4) If all conditions satisfy then return the result in boolean
		 * 
		 * 
		 */

		if (number <= 0) {
			return false;
		}

		if (number == 1 && number == 2) {
			return true;
		}

		for (long i = number - 1; i > 1; i--) {

			if (number % i == 0) {
				return false;
			}

		}

		return true;

	}

	@Override
	public List<Boolean> varifyPrimeNumberNoraml(List<Integer> numbers) {
		List<Boolean> results = new ArrayList<Boolean>();
		numbers.stream().forEach(number -> {

			Boolean result = this.isPrimeNumber(number);
			results.add(result);

		});

		return results;
	}

}
