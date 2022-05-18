package com.example.newsApp.controllers;

import com.example.newsApp.response.UserResponseDTO;
import com.example.newsApp.model.User;
import com.example.newsApp.response.UserDTO;
import com.example.newsApp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
    final UserService userService;
    final ModelMapper modelMapper = new ModelMapper();

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponseDTO> get() {
        List<UserResponseDTO> userResponseDTOS = userService.getAllUsers()
                .stream()
                .map(user -> modelMapper.map(user, UserResponseDTO.class))
                .collect(Collectors.toList());
        return userResponseDTOS;
    }

    @GetMapping("/get/{id}")
    public List<UserResponseDTO> getUserByID(@PathVariable("id") Long id) {
        List<UserResponseDTO> userResponseDTOS = userService.getUserById(id)
                .stream()
                .map(user -> modelMapper.map(user, UserResponseDTO.class))
                .collect(Collectors.toList());
        return userResponseDTOS;
    }

    @PostMapping("/create")
    public void createNewUser(@RequestBody UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        userService.addUser(user);
    }

    @GetMapping("/delete/{id}")
    public void deleteUserByID(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/update/{id}")
    public void add(@RequestBody UserDTO userDTO, @PathVariable("id") Long id ) {
//        User user = modelMapper.map(userDTO, User.class);
        userService.updateUser(userDTO, id);
    }
}
