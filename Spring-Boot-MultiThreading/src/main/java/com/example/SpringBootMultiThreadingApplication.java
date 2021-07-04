package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class SpringBootMultiThreadingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultiThreadingApplication.class, args);
	}

}
