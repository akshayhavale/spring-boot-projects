package com.example.immutableobject;

import java.util.ArrayList;
import java.util.List;

public class TestImmutable {

	public static void main(String[] args) {

		Address address1 = new Address("Hubli");
		Address address2 = new Address("Bangalore");
		List<Address> addresss = new ArrayList<>();
		addresss.add(address1);
		addresss.add(address2);
		Person personOriginal = new Person("Akshay", "Havale", addresss);

		System.out.println(personOriginal);

		// now i am going to change the Person's addresses

		Address address3 = new Address("Srilanka");
		personOriginal.getAddresss().set(0, address3);
		personOriginal.getAddresss().remove(1);
		System.out.println(personOriginal);

	}

}
