package com.example.model;

import com.example.model.constants.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private String firstname;
	private String lastname;
	private int age;
	private UserType userType;
	private Address address;

}
