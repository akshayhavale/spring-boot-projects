package com.example.dtos;

import lombok.Data;

@Data
public class UserDto {

	private String firstname;
	private String lastname;
	private AddressDto address;

}
