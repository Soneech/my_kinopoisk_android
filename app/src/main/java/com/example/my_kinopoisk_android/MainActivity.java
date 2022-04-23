package com.example.my_kinopoisk_android;

import androidx.appcompat.app.AppCompatActivity;

import android.media.metrics.Event;
import android.os.Bundle;

import org.springframework.web.client.RestTemplate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestTemplate restTemplate = new RestTemplate();
        //Event event = restTemplate.getForObject("https://myapp.com/event/{name}", Event.class, "springone2gx");
    }
}