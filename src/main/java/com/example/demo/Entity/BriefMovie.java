package com.example.demo.Entity;

public class BriefMovie {
    private int id;
    private String title;
    private double rating;
    private String genres;
    private String year;
    private String photos;
    private String summary;

    public BriefMovie(int id, String title, double rating, String genres, String year, String photos, String summary) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.genres = genres;
        this.year = year;
        this.photos = photos;
        this.summary = summary;
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
}
