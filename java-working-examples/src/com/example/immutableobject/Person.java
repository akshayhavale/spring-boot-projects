package com.example.immutableobject;

import java.util.ArrayList;
import java.util.List;

public final class Person {

	private final String firstName;
	private final String lastName;
	private final List<Address> addresss;

	public Person(String firstName, String lastName, List<Address> addresss) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.addresss = addresss;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public List<Address> getAddresss() {
		List<Address> clone = new ArrayList<Address>();
		for (Address address : this.addresss) {
			clone.add(address);
		}
		return clone;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", address=" + addresss + "]";
	}

}
