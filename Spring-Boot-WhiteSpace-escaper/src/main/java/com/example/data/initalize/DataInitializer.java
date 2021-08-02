package com.example.data.initalize;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.example.model.User;

@Configuration
public class DataInitializer {

	private static List<User> users = new ArrayList<>();

//	@PostConstruct
//	public void initializeUsers() {
//		Address address = new Address("   Hubli", "  580023");
//		User user = new User("  Akshay", "  Havale", address);
//		users.add(user);
//	}

	public List<User> getUsers() {
		return users;
	}

}
