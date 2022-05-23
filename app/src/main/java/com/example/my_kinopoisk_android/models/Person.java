package com.example.my_kinopoisk_android.models;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Person {
    private Long id;
    private String name;
    private String surname;
    private String description;
    private Float height;
    private Date birthday;
    private Gender gender;
    private Set<Actor> actorRoles = new HashSet<>();
    private Set<FilmCrew> filmCrewRoles = new HashSet<>();
    private Set<Genre> genres = new HashSet<>();

    Person() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Set<Actor> getActorRoles() {
        return actorRoles;
    }

    public void setActorRoles(Set<Actor> actorRoles) {
        this.actorRoles = actorRoles;
    }

    public Set<FilmCrew> getFilmCrewRoles() {
        return filmCrewRoles;
    }

    public void setFilmCrewRoles(Set<FilmCrew> filmCrewRoles) {
        this.filmCrewRoles = filmCrewRoles;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }
}
