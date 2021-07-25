package com.example.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address {

	@Column(name = "LINE1")
	private String line1;

	@Column(name = "LINE2")
	private String line2;

	@Column(name = "STREET")
	private String street;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STATE")
	private String state;

	@Column(name = "ZIPCODE")
	private String zipcode;

}
