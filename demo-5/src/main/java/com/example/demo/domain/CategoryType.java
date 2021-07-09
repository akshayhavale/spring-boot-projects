package com.example.demo.domain;

import java.util.Arrays;
import java.util.Optional;

public enum CategoryType {

	SNEAKERS("SNEAKERS"), STREETWEARS("STREETWEARS"),
	BAGS("BAGS"),
	WATCHES("WATCHES"),
	TOYS("TOYS"),
	NO_MATCH("NO-MATCH"),
	BULK_UPLOAD_REPORT("BULK_UPLOAD_REPORT");

	private final String name;

	private CategoryType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	 public static Optional<CategoryType> fromText(String text) {
	        return Arrays.stream(values())
	          .filter(bl -> bl.name.equalsIgnoreCase(text))
	          .findFirst();
	    }
}
