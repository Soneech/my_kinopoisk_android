package com.example.my_kinopoisk_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

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
                final String url = "https://university-project-movie.herokuapp.com/movies?page=0&size=1";

                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                String json = restTemplate.getForObject(url, String.class);

                ObjectNode node = new ObjectMapper().readValue(json, ObjectNode.class);
                ObjectMapper mapper = new ObjectMapper();
                Movie movie = mapper.readValue(node.get("content").toString(), Movie[].class)[0];
                Log.d("RRR", movie.getTitle());

                return movie;
            } catch (Exception e) {
                Log.e("RRR", e.getMessage(), e);
            }
            return null;
        }
    }
}