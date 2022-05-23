package com.example.my_kinopoisk_android;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.my_kinopoisk_android.api.NetworkService;
import com.example.my_kinopoisk_android.databinding.ActivityMovieBinding;
import com.example.my_kinopoisk_android.models.Movie;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieActivity extends AppCompatActivity {

    private int moviesCount = 9;
    private ActivityMovieBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMovieBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int position = getIntent().getIntExtra("position", 0);
        getData(position);
    }

    public void getData(int position) {

    }
}