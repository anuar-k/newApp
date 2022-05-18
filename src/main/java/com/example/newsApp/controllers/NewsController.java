package com.example.newsApp.controllers;

import com.example.newsApp.model.News;
import com.example.newsApp.service.NewsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public List<News> getNews() {
        return newsService.getAllNews();
    }

}