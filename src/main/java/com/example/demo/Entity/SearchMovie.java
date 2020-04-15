package com.example.demo.Entity;

public class SearchMovie {
    private int id;
    private String title;
    private String original_title;
    private double rating;
    private String genres;
    private String year;
    private String photos;
    private String summary;
    private String cast;

    public SearchMovie(int id, String title, String original_title, double rating, String genres, String year, String photos, String summary, String cast) {
        this.id = id;
        this.title = title;
        this.original_title = original_title;
        this.rating = rating;
        this.genres = genres;
        this.year = year;
        this.photos = photos;
        this.summary = summary;
        this.cast = cast;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }
}
