package com.example.my_kinopoisk_android.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.my_kinopoisk_android.Movie;
import com.example.my_kinopoisk_android.MyRecyclerViewAdapter;
import com.example.my_kinopoisk_android.R;
import com.example.my_kinopoisk_android.databinding.FragmentMoviesListBinding;

public class MoviesListFragment extends Fragment {

    private FragmentMoviesListBinding binding;
    private FragmentActions fragmentActions;
    private Movie movies;

    MyRecyclerViewAdapter adapter;

    public MoviesListFragment(Movie movies) {
        //this.movies = movies;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMoviesListBinding.inflate(inflater, container, false);

        return inflater.inflate(R.layout.fragment_movies_list, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentActions = (FragmentActions) context;
    }
}