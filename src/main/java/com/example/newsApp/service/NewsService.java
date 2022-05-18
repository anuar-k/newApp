package com.example.newsApp.service;

import com.example.newsApp.model.News;
import com.example.newsApp.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public void add(News user) {
        newsRepository.save(user);
    }
}
