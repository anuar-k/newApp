package com.example.newsApp.service;

import com.example.newsApp.model.User;
import com.example.newsApp.repository.UserRepository;
import com.example.newsApp.response.UserDTO;
import com.example.newsApp.response.UserResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@Transactional
@Service
public class UserService {
    final EntityManager entityManager;
    final UserRepository userRepository;

    public UserService(UserRepository userRepository, EntityManager entityManager) {
        this.entityManager = entityManager;
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<UserResponseDTO> getUserById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        List<UserResponseDTO> users = userRepository.findUserById(id)
                .stream()
                .map(user -> modelMapper.map(user, UserResponseDTO.class))
                .collect(Collectors.toList());
        return users;
    }

    public void addUser(User user) {
        user.setCreated_at(LocalDate.now());
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        User user = entityManager.find(User.class, userId);
        try {
            entityManager.remove(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(UserDTO userDTO, Long id) {
        try {
            if (userIsExist(id) != true){
                System.out.println("not found");
            }
            ModelMapper modelMapper = new ModelMapper();
            User currentUser = entityManager.find(User.class, id);
            User newUser = modelMapper.map(userDTO, User.class);
            if (newUser.getName() != null) {
                currentUser.setName(newUser.getName());
            }
            if (newUser.getSurname() != null) {
                currentUser.setSurname(userDTO.getSurname());
            }
            if (newUser.getPhoto() != null) {
                currentUser.setPhoto(userDTO.getPhoto());
            }
            if (newUser.getPhone() != null) {
                currentUser.setPhone(userDTO.getPhone());
            }
            if (newUser.getEmail() != null) {
                currentUser.setEmail(userDTO.getEmail());
            }
            if (newUser.getPassword() != null) {
                currentUser.setPassword(userDTO.getPassword());
            }
            entityManager.persist(currentUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean userIsExist(Long id) throws NullPointerException{
        User currentUser = entityManager.find(User.class, id);
        if (id.equals(currentUser.getId())){
            return true;
        }
        return false;
    }
}
