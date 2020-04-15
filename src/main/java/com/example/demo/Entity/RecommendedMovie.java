package com.example.demo.Entity;

public class RecommendedMovie {
    private int id;
    private String title;
    private String photos;

    public RecommendedMovie(int id, String title, String photos) {
        this.id = id;
        this.title = title;
        this.photos = photos;
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

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }
}
