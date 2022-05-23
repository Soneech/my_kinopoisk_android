package com.example.my_kinopoisk_android.models;

import java.util.ArrayList;
import java.util.List;

public class Genre {
    private Long id;
    private String title;
    private List<Movie> movies = new ArrayList<>();
    private List<Person> persons = new ArrayList<>();

    Genre() {

    }

    public Genre(Long id, String title, List<Movie> movies, List<Person> persons) {
        this.id = id;
        this.title = title;
        this.movies = movies;
        this.persons = persons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
