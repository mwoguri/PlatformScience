package com.example.platformscience.data;

import java.util.Objects;

public class NewsItem {
    String author;
    String title;
    String description;
    String urlToImage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsItem newsItem = (NewsItem) o;
        return Objects.equals(author, newsItem.author) &&
                Objects.equals(title, newsItem.title) &&
                Objects.equals(description, newsItem.description) &&
                Objects.equals(urlToImage, newsItem.urlToImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, description, urlToImage);
    }

    @Override
    public String toString() {
        return "NewsItem{" +
                "title='" + title + '\'' +
                '}';
    }
}
