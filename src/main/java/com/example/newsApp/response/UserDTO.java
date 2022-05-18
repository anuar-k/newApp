package com.example.newsApp.response;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
public class UserDTO {
    private String name;
    private String surname;
    private String email;
    private String photo;
    private String phone;
    private String password;
    @Column
    private LocalDate created_at;
}
