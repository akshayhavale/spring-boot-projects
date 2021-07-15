package com.example;

import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.uuid.Generators;

@SpringBootApplication
public class SpringBootUuidGeneratorAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUuidGeneratorAppApplication.class, args);
		
		
		
		UUID uuid = Generators.timeBasedGenerator().generate();
		System.out.println(uuid.toString());
	}

}
