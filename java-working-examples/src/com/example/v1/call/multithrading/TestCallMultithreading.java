package com.example.v1.call.multithrading;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallMultithreading {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Callable<String> callable1 = new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "Akshay";
			}
		};

		Callable<String> callable2 = new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "Akshay";
			}
		};

		ExecutorService executor = Executors.newSingleThreadExecutor();

		CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> "akshay", executor)
				.thenAccept(s -> System.out.println(s + "havale"));

	}

}
