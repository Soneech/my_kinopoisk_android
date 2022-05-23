package com.example.my_kinopoisk_android.api;

import com.example.my_kinopoisk_android.models.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JSONPlaceHolderApi {
    @GET("/movies/{id}")
    public Call<Movie> getPostWithID(@Path("id") int id);

}
