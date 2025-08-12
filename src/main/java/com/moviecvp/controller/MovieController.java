package com.moviecvp.controller;

import com.moviecvp.model.Movie;
import com.moviecvp.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public String index(Model model, @RequestParam(required = false) String query) {
        List<Movie> movies;
        if (query != null && !query.isEmpty()) {
            movies = movieService.searchMovies(query);
            model.addAttribute("query", query);
        } else {
            movies = movieService.getTrendingMovies();
        }
        model.addAttribute("movies", movies);
        return "index";
    }

    @GetMapping("/movie/{id}")
    public String movieDetails(@RequestParam Long id, Model model) {
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        return "movie-details";
    }
}
