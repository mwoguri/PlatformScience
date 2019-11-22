package com.example.platformscience.data;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsController implements Callback<NewsResponse> {
    final String TAG = getClass().getSimpleName();
    static final String API_KEY = "c02bec1b92254371b114076fa31fc66b"; //TODO obfuscate key?
    static final String BASE_URL = "https://newsapi.org";

    public void requestPage(int page) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        NewsapiService newsapiService = retrofit.create(NewsapiService.class);

        Call<NewsResponse> apiCall = newsapiService.getNews(API_KEY, page, "android");
        apiCall.enqueue(this);

    }

    @Override
    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
        if (response.isSuccessful()) {
            NewsResponse news = response.body();
            Log.d(TAG, news.toString());

        } else {
            Log.e(TAG, "Error: " + response.code());
        }
    }

    @Override
    public void onFailure(Call<NewsResponse> call, Throwable t) {
        Log.e(TAG, t.getLocalizedMessage());
    }
}