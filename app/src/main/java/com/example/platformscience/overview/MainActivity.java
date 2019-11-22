package com.example.platformscience.overview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.platformscience.R;
import com.example.platformscience.data.NewsItem;
import com.mindorks.placeholderview.InfinitePlaceHolderView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    InfinitePlaceHolderView infiniteNewsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        infiniteNewsView = findViewById(R.id.infiniteNewsView);
        NewsListView newsResolver = new NewsListView(infiniteNewsView, new ArrayList<NewsItem>());
        infiniteNewsView.setLoadMoreResolver(newsResolver);
        newsResolver.onLoadMore();
    }
}
