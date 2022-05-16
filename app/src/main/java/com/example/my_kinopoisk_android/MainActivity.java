package com.example.my_kinopoisk_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener{

    MyRecyclerViewAdapter adapter;
    private Movie movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> moviesTitles = new ArrayList<>();
        moviesTitles.add("Звёздные войны");
        moviesTitles.add("Ведьмак");
        moviesTitles.add("Ещё что-то");

        RecyclerView recyclerView = findViewById(R.id.moviesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, moviesTitles);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        new HttpRequestTask().execute();
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this, MovieActivity.class);
        startActivity(intent);
    }

    private class HttpRequestTask extends AsyncTask<Void, Void, Movie> {
        @Override
        protected Movie doInBackground(Void... params) {
            try {
                final String url = "http://127.0.0.1:8082/movies/0";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                movies = restTemplate.getForObject(url, Movie.class);
                return movies;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }
            return null;
        }
    }
}