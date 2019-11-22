package com.example.platformscience.data;

import java.util.List;

public class NewsResponse {
    int totalResults;
    List<NewsItem> articles;

    @Override
    public String toString() {
        return "NewsResponse{" +
                "totalResults=" + totalResults +
                ", articles=" + articles +
                '}';
    }
}
