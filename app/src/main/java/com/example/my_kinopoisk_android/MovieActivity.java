package com.example.my_kinopoisk_android;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.my_kinopoisk_android.databinding.ActivityMovieBinding;

public class MovieActivity extends AppCompatActivity {

    private ActivityMovieBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMovieBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}