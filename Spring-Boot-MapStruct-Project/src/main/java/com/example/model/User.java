package com.example.model;

import lombok.Data;

@Data
public class User {

	private Long id;
	private String firstname;
	private String lastname;
	private Address address;
}
