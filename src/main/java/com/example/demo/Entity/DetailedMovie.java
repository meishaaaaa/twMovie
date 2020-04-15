package com.example.demo.Entity;


import java.util.List;

public class DetailedMovie {
    private Integer id;
    private String title;
    private String original_title;
    private double rating;
    private String genres;
    private String year;
    private String pubdates;
    private String summary;
    private String durations;
    private String photos;
    private String album;
    private String cast;
    private List<RecommendedMovie> recommendation;

    public DetailedMovie(Integer id, String title, String original_title, double rating, String genres, String year, String pubdates, String summary, String durations, String photos, String album, String cast, List<RecommendedMovie> recommendation) {
        this.id = id;
        this.title = title;
        this.original_title = original_title;
        this.rating = rating;
        this.genres = genres;
        this.year = year;
        this.pubdates = pubdates;
        this.summary = summary;
        this.durations = durations;
        this.photos = photos;
        this.album = album;
        this.cast = cast;
        this.recommendation = recommendation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPubdates() {
        return pubdates;
    }

    public void setPubdates(String pubdates) {
        this.pubdates = pubdates;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDurations() {
        return durations;
    }

    public void setDurations(String durations) {
        this.durations = durations;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public List<RecommendedMovie> getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(List<RecommendedMovie> recommendation) {
        this.recommendation = recommendation;
    }
}
