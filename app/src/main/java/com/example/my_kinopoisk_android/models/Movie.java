package com.example.my_kinopoisk_android.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashSet;
import java.util.Set;

public class Movie {
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("ageLimit")
    @Expose
    private Integer ageLimit;
    @SerializedName("countryOfProduction")
    @Expose
    private String countryOfProduction;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("releaseDate")
    @Expose
    private String releaseDate;
    @SerializedName("genres")
    @Expose
    private Set<Genre> genres = new HashSet<>();
    @SerializedName("actors")
    @Expose
    private Set<Actor> actors = new HashSet<>();
    @SerializedName("filmCrews")
    @Expose
    private Set<FilmCrew> filmCrews = new HashSet<>();

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

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public String getCountryOfProduction() {
        return countryOfProduction;
    }

    public void setCountryOfProduction(String countryOfProduction) {
        this.countryOfProduction = countryOfProduction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
