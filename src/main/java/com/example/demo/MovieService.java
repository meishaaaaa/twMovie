package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Movie getInfo(int id){
        return movieRepository.findById(id).orElse(null);
    }

    public List<Movie> SearchByKeyWords(String keywords){
        String newKey="%"+keywords+"%";
        List<Movie> list= movieRepository.findKeyWord(newKey);
        return list;
    }

}
