package com.example.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.dtos.AddressDto;
import com.example.dtos.UserDto;
import com.example.model.Address;
import com.example.model.User;

@Mapper(implementationPackage = "mapper.impl")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	/*
	 * Simply to map different Feild names use this
	 * 
	 * 
	 * @Mapping(target = "firstname",source = "userDto.firstname")
	 * 
	 * or for compound implementation
	 * 
	 * @Mappings({@Mapping(target = "firstname",source = "userDto.firstname")})
	 */
	
	User userDtoToUser(UserDto userDto);

	UserDto userToUserDto(User user);

	AddressDto addressToAddressDto(Address address);

	Address addressDtoToAddress(AddressDto addressDto);
}
