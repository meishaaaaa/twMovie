package com.example.demo;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

    @Query(value="SELECT * FROM movie WHERE title LIKE :key OR original_title LIKE :key")
    public List<Movie> findKeyWord(@Param("key") String key);

    @Query("SELECT m from movie m where genres like %:genres")
    public List<Movie> findGenres(@Param("genres") String genres);

}
