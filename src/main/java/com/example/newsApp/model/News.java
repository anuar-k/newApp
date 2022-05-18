package com.example.newsApp.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@Data
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String author;
    String text;
}