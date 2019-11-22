package com.example.platformscience.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsapiService {
    @GET("v2/everything")
    Call<NewsResponse> getNews(@Query("apiKey") String key,
                               @Query("page") int pageNum,
                               @Query("q") String query);
}