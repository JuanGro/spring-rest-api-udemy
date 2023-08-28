package com.demo.springboot.service.impl;

import com.demo.springboot.dto.UserDto;
import com.demo.springboot.entity.User;
import com.demo.springboot.mapper.UserMapper;
import com.demo.springboot.repository.UserRepository;
import com.demo.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {
        User userToCreate = UserMapper.MAPPER.mapToUser(user);
        User userCreated = userRepository.save(userToCreate);
        return UserMapper.MAPPER.mapToUserDto(userCreated);
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).get();
        return UserMapper.MAPPER.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper.MAPPER::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user, Long id) {
        User userToUpdate = userRepository.findById(id).get();
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmailAddress());
        User updatedUser = userRepository.save(userToUpdate);
        return UserMapper.MAPPER.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
