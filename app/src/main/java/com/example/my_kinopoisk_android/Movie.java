package com.example.my_kinopoisk_android;

public class Movie {

    private Long id;
    private String title;
    private Integer ageLimit;
    private String countryOfProduction;

    public Movie(Long id, String title, Integer ageLimit, String countryOfProduction) {
        this.id = id;
        this.title = title;
        this.ageLimit = ageLimit;
        this.countryOfProduction = countryOfProduction;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getAgeLimit() {
        return ageLimit;
    }

    public String getCountryOfProduction() {
        return countryOfProduction;
    }
}
