package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping(value = "/index")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/search/{key}", method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> findKeywords(@PathVariable("key") String key) {
        return  movieService.SearchByKeyWords(key);
    }

    @RequestMapping(value = "/key/{key}", method = RequestMethod.GET)
    public void findKey(@PathVariable("key") String key, HttpServletResponse response) throws Exception{
        List<Movie> movies = movieService.SearchByKeyWords(key);
        for (Movie m : movies) {
            Json.toJson(m,response);
        }
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public @ResponseBody Movie getDetails(@PathVariable("id") int id)
    {
    return movieService.getInfo(id);
    }

}





