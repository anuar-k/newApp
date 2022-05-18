package com.example.newsApp.model;

import com.example.newsApp.response.UserDTO;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String photo;
    private String phone;
    private String password;
    @CreatedBy
    private LocalDate created_at;
}
