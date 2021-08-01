package com.example.controller;

import com.example.dtos.UserDto;
import com.example.mapper.UserMapper;
import com.example.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping(value = "/userDtoToUser")
    public @ResponseBody
    User userDtoToUser(@RequestBody UserDto userDto) {
        User user = UserMapper.INSTANCE.userDtoToUser(userDto);
        return user;
    }

    @PostMapping(value = "/userToUserDto")
    public @ResponseBody
    UserDto userToUserDTO(@RequestBody User user) {
        UserDto userDto = UserMapper.INSTANCE.userToUserDto(user);
        return userDto;
    }


}
