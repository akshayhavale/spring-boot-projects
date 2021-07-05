package com.example.v1.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PrimeNumberService {

	CompletableFuture<List<Boolean>> varifyPrimeNumber(List<Integer> numbers);

	List<Boolean> varifyPrimeNumberNoraml(List<Integer> numbers);

}
