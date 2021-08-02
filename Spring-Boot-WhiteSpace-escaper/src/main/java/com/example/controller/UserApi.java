package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.data.initalize.DataInitializer;
import com.example.model.User;

@RestController
public class UserApi {

	@Autowired
	private DataInitializer initializer;

	@GetMapping("/users")
	public List<User> getUsers() {
		return initializer.getUsers();
	}

	@PostMapping("/users")
	public List<User> createUser(@RequestBody User user) {
		List<User> users = initializer.getUsers();
		users.add(user);
		return users;
	}

}
