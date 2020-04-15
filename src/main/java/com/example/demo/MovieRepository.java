package com.example.demo;

import com.example.demo.Entity.Movie;
import com.example.demo.Entity.RecommendedMovie;
import com.example.demo.Entity.SearchMovie;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

//    @Query(value = "SELECT * FROM movie WHERE title LIKE :key OR original_title LIKE :key")
//    public List<Movie> findKeyWord(@Param("key") String key);

    @Query(value = "SELECT id, title, original_title,rating,genres,year,photos,summary,cast FROM movie WHERE title LIKE :key OR original_title LIKE :key")
    public List<SearchMovie> findKeywords(@Param("key") String key);

    @Query("SELECT * FROM movie WHERE genres LIKE :genres ORDER BY rating DESC LIMIT :limit ")
    public List<Movie> moviesByRating(@Param("genres") String genres, @Param("limit") int limit);

    @Query("SELECT * FROM movie WHERE genres LIKE :genres ORDER BY rand() DESC LIMIT :limit ")
    public List<Movie> moviesByRandom(@Param("genres") String genres, @Param("limit") int limit);

    @Query("SELECT * FROM movie ORDER BY rating DESC")
    public List<Movie> allMoviesByRating(@Param("limit") int limit);

    @Query("SELECT * FROM movie ORDER BY random DESC ")
    public List<Movie> allMoviesByRandom(@Param("limit") int limit);

    @Query("SELECT * FROM movie WHERE genres LIKE :genres ORDER BY rating DESC")
    public List<Movie> moviesByRating(@Param("genres") String genres);

    @Query("SELECT * FROM movie WHERE genres LIKE :genres ORDER BY rand() DESC  ")
    public List<Movie> moviesByRandom(@Param("genres") String genres);

    @Query("SELECT * FROM movie ORDER BY rating DESC ")
    public List<Movie> allMoviesByRating();

    @Query("SELECT * FROM movie ORDER BY random DESC")
    public List<Movie> allMoviesByRandom();

    @Query("SELECT id, title, photos FROM movie WHERE genres LIKE :genres ORDER BY rating DESC ")
    List<RecommendedMovie> getRecommendedMovies(@Param("genres") String genres);
}
