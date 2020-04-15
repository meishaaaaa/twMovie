package com.example.demo;

import com.example.demo.Entity.BriefMovie;
import com.example.demo.Entity.DetailedMovie;
import com.example.demo.Entity.Movie;
import com.example.demo.Entity.SearchMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/index")
public class MovieController {
    @Autowired
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    @ResponseBody
    public DetailedMovie getDetails(@PathVariable("id") int id) {
        return movieService.getInfo(id);
    }

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    @ResponseBody
    public List<BriefMovie> getMovies(@RequestParam String genres, @RequestParam String sorting, @RequestParam int limit) {
        return movieService.getMovies(genres, sorting, limit);
    }
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public List<SearchMovie> searchKey(@RequestParam("keywords") String keywords) {
        return movieService.keyWords(keywords);
    }

}





