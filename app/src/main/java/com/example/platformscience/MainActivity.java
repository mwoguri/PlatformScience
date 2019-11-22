package com.example.platformscience;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.platformscience.data.NewsController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NewsController newsController = new NewsController();
        newsController.requestPage(1);
    }
}
