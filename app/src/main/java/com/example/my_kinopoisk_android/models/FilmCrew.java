package com.example.my_kinopoisk_android.models;

public class FilmCrew {
    private Long id;
    private String name;
    private String surname;
    private String role;
    private Person person;
    private Movie movie;
    private Long personId;

    FilmCrew() {

    }

    public FilmCrew(Long id, String name, String surname, String role, Person person, Movie movie, Long personId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.person = person;
        this.movie = movie;
        this.personId = personId;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
