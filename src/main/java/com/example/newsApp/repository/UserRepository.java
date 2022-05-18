package com.example.newsApp.repository;

import com.example.newsApp.model.User;
import com.example.newsApp.response.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findUserById(Long id);

    void deleteAllById(Long id);
}
