package com.example.my_kinopoisk_android;

public class Movie {

    private Long id;
    private String title;
    private Integer ageLimit;
    private String countryOfProduction;

    Movie() {

    }

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAgeLimit(Integer ageLimit) {
        this.ageLimit = ageLimit;
    }

    public void setCountryOfProduction(String countryOfProduction) {
        this.countryOfProduction = countryOfProduction;
    }
}
