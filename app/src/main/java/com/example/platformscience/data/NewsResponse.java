package com.example.platformscience.data;

import java.util.List;

public class NewsResponse {
    int totalResults;
    List<NewsItem> articles;

    public List<NewsItem> getArticles() {
        return articles;
    }

    @Override
    public String toString() {
        return "NewsResponse{" +
                "totalResults=" + totalResults +
                ", articles=" + articles +
                '}';
    }
}
