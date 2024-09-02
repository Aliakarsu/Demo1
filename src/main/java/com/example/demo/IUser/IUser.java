package com.example.demo.IUser;

import com.example.demo.User.UserDto;

import java.util.List;

public interface IUser {

    UserDto addName(UserDto userDto);
    List<UserDto> getNamesStartingWith(String name, String gender);
    UserDto getUserById(Long id);
    UserDto deleteUserById(Long id);
    UserDto updateUserById(UserDto userDto);
}
