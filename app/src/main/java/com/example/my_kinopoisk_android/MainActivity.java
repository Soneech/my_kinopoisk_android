package com.example.my_kinopoisk_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String url = "https://localhost:8082/movies/0";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        Movie movie = restTemplate.getForObject(url, Movie.class);
    }
}