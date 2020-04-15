package com.example.demo;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("movie")
public class Movie {
    @Id
    @Column("id")
    private Integer id;
    @Column("title")
    private String title;
    @Column("original_title")
    private String originalTitle;
    @Column("rating")
    private double rating;
    @Column("genres")
    private String genres;
    @Column("year")
    private String year;
    @Column("pubdates")
    private String pubdates;
    @Column("summary")
    private String summary;
    @Column("durations")
    private String durations;
    @Column("photos")
    private String photos;
    @Column("album")
    private String album;
    @Column("cast")
    private String cast;

    public Movie(Integer id, String title, String originalTitle, double rating, String genres, String year, String pubdates, String summary, String durations, String photos, String album, String cast) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.rating = rating;
        this.genres = genres;
        this.year = year;
        this.pubdates = pubdates;
        this.summary = summary;
        this.durations = durations;
        this.photos = photos;
        this.album = album;
        this.cast = cast;
    }

}