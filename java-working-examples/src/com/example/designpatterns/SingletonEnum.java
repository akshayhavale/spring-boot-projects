package com.example.designpatterns;

import java.util.ArrayList;
import java.util.List;

public enum SingletonEnum {
	

	INSTANCE;

	private String firstname;
	private String lastname;

	public String connection() {
		return new StringBuilder("Connecting to MySql").toString();
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	
}
