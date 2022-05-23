package com.example.my_kinopoisk_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_kinopoisk_android.api.NetworkService;
import com.example.my_kinopoisk_android.models.Movie;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener{

    private MyRecyclerViewAdapter adapter;
    private ArrayList<Movie> movies = new ArrayList<>();
    private ArrayList<String> moviesTitles;
    private int moviesCount = 9;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.moviesRecyclerView);

        moviesTitles = new ArrayList<>();
        getData();

        for (int i = 0; i < moviesCount; i++) {
            Log.d("RR1", movies.get(i).getTitle());
        }
        Log.d("RRR", String.valueOf(movies.size()));
    }

    public void updateData(Movie movie) {
        moviesTitles.add(movie.getTitle());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, moviesTitles);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    public void getData() {
        for (int i = 1; i <= moviesCount; i++) {
            NetworkService.getInstance()
                    .getJSONApi()
                    .getPostWithID(i)
                    .enqueue(new Callback<Movie>() {
                        @Override
                        public void onResponse(@NonNull Call<Movie> call, @NonNull Response<Movie> response) {
                            Movie movie = response.body();
                            updateData(movie);
                            movies.add(movie);
                            Log.d("RRR", String.valueOf(movies.size()));
                        }

                        @Override
                        public void onFailure(@NonNull Call<Movie> call, @NonNull Throwable t) {
                            Log.d("ERROR", t.getMessage());
                        }
                    });
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this, MovieActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}