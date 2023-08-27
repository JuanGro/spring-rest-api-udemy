package com.demo.springboot.service;

import com.demo.springboot.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(User user, Long id);

    void deleteUser(Long id);
}
