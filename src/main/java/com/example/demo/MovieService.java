package com.example.demo;

import com.example.demo.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public DetailedMovie getInfo(Integer id) {

        if (movieRepository.findById(id).isPresent()) {
            Movie movie = movieRepository.findById(id).get();
            List<RecommendedMovie> list = getRecommendation(movie);
            DetailedMovie dm = new DetailedMovie(
                    movie.getId(), movie.getTitle(), movie.getOriginal_title(), movie.getRating(), movie.getGenres(), movie.getYear(), movie.getPubdates(), movie.getSummary(), movie.getDurations(), movie.getPhotos(), movie.getAlbum(), movie.getCast(), list);
            return dm;
        }
        return null;
    }


    public List<SearchMovie> keyWords(String keywords) {
        String newKey = "%" + keywords + "%";
        return movieRepository.findKeywords(newKey);
    }

    public List<BriefMovie> getMovies(String genres, String sorting, int limit) {
        String all = "全部";
        if (!Objects.equals(genres, all)) {
            genres = "%" + genres + "%";
        }
        List<Movie> list = new ArrayList<>();
        switch (limit) {
            case (0):
                list = noLimit(genres, sorting);
                break;
            default:
                list = withLimit(genres, sorting, limit);
        }
        List<BriefMovie> briefMovies = list.stream().map(m -> new BriefMovie(m.getId(), m.getTitle(), m.getRating(), m.getGenres(), m.getYear(), m.getPhotos(), m.getSummary())).collect(Collectors.toList());
        return briefMovies;
    }

    private List<Movie> noLimit(String genres, String sorting) {
        String all = "全部";
        if (Objects.equals(genres, all)) {
            return sorting.equals("top") ? movieRepository.allMoviesByRating() :
                    sorting.equals("random") ? movieRepository.allMoviesByRandom() :
                            null;
        } else return sorting.equals("top") ? movieRepository.moviesByRating(genres) :
                sorting.equals("random") ? movieRepository.moviesByRandom(genres) :
                        null;

    }

    private List<Movie> withLimit(String genres, String sorting, int limit) {
        String all = "全部";
        if (Objects.equals(genres, all)) {
            return sorting.equals("top") ? movieRepository.allMoviesByRating(limit) :
                    sorting.equals("random") ? movieRepository.allMoviesByRandom(limit) :
                            null;
        } else return sorting.equals("top") ? movieRepository.moviesByRating(genres, limit) :
                sorting.equals("random") ? movieRepository.moviesByRandom(genres, limit) :
                        null;

    }

    public List<RecommendedMovie> getRecommendation(Movie movie) {
        String genres = movie.getGenres();
        String[] genreArray = genres.split(",");
        List<RecommendedMovie> recommendedList = new ArrayList<>();
        Stream<RecommendedMovie> rm = recommendedList.stream();

        for (String s : genreArray) {
            s = "%" + s + "%";
            rm = Stream.concat(rm, movieRepository.getRecommendedMovies(s).stream());
        }

        List<RecommendedMovie> collect = rm.distinct().filter(m -> m.getId() != movie.getId()).limit(6).collect(Collectors.toList());
        for (RecommendedMovie r : collect) {
            r.setPhotos(r.getPhotos().split(",")[0]);
        }

        return collect;
    }

}

//    public List<SearchMovie> SearchByKeyWords(String keywords) {
//        String newKey = "%" + keywords + "%";
//        List<Movie> list = movieRepository.findKeyWord(newKey);
//        List<SearchMovie> searchList = list.stream().map(m -> new SearchMovie(m.getId(), m.getTitle(), m.getOriginal_title(), m.getRating(), m.getGenres(), m.getYear(), m.getPhotos(), m.getSummary(), m.getCast())).collect(Collectors.toList());
//        return searchList;
//    }