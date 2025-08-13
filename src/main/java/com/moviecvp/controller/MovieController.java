package com.moviecvp.controller;

import com.moviecvp.model.FavoriteMovie;
import com.moviecvp.model.Movie;
import com.moviecvp.repository.FavoriteMovieRepository;
import com.moviecvp.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class MovieController {

    private final MovieService movieService;
    private final FavoriteMovieRepository favoriteMovieRepository;

    public MovieController(MovieService movieService, FavoriteMovieRepository favoriteMovieRepository) {
        this.movieService = movieService;
        this.favoriteMovieRepository = favoriteMovieRepository;
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

        // Get all favorite movie IDs from the repository
        List<FavoriteMovie> favorites = favoriteMovieRepository.findAll();
        Set<Long> favoriteIds = favorites.stream()
                .map(FavoriteMovie::getId)
                .collect(Collectors.toSet());

        model.addAttribute("movies", movies);
        model.addAttribute("favoriteIds", favoriteIds); // Add the set to the model

        return "index";
    }

    @GetMapping("/movie/{id}")
    public String movieDetails(@PathVariable Long id, Model model) {
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);

        // Add a flag to check if the movie is a favorite
        boolean isFavorite = favoriteMovieRepository.existsById(id);
        model.addAttribute("isFavorite", isFavorite);

        return "movie-details";
    }
}
