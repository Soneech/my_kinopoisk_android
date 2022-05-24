package com.example.my_kinopoisk_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_kinopoisk_android.api.NetworkService;
import com.example.my_kinopoisk_android.models.Movie;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener{

    private MyRecyclerViewAdapter adapter;
    private ArrayList<Movie> movies = new ArrayList<>();
    private final int MOVIES_COUNT = 9;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.moviesRecyclerView);

        getData();
    }

    public void updateData(Movie movie) {
        movies.add(movie);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, movies);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    public void getData() {
        for (int i = 1; i <= MOVIES_COUNT; i++) {
            NetworkService.getInstance()
                    .getJSONApi()
                    .getPostWithID(i)
                    .enqueue(new Callback<Movie>() {
                        @Override
                        public void onResponse(@NonNull Call<Movie> call, @NonNull Response<Movie> response) {
                            Movie movie = response.body();
                            updateData(movie);
                        }

                        @Override
                        public void onFailure(@NonNull Call<Movie> call, @NonNull Throwable t) {
                            Log.d("ERROR", t.getMessage());
                        }
                    });
        }
    }

    @Override
    public void onItemClick(View view, Movie movie) {
        showMovieWindow(movie);
    }

    public void showMovieWindow(Movie movie) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(R.string.description);

        LayoutInflater inflater = LayoutInflater.from(this);
        View movieWindow = inflater.inflate(R.layout.movie_window, null);
        dialog.setView(movieWindow);

        final TextView descriptionTextView = movieWindow.findViewById(R.id.descriptionTextView);
        descriptionTextView.setText(movie.getDescription());

        dialog.setNegativeButton(R.string.close, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        dialog.show();
    }
}