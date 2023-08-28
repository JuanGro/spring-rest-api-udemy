package com.demo.springboot.service;

import com.demo.springboot.dto.UserDto;
import com.demo.springboot.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto userDto, Long id);

    void deleteUser(Long id);
}
