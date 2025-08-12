package com.moviecvp.controller;

import com.moviecvp.model.FavoriteMovie;
import com.moviecvp.model.Movie;
import com.moviecvp.repository.FavoriteMovieRepository;
import com.moviecvp.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FavoriteController {

    private final FavoriteMovieRepository favoriteMovieRepository;
    private final MovieService movieService;

    public FavoriteController(FavoriteMovieRepository favoriteMovieRepository, MovieService movieService) {
        this.favoriteMovieRepository = favoriteMovieRepository;
        this.movieService = movieService;
    }

    @PostMapping("/favorites/add")
    public String addFavorite(@RequestParam Long movieId) {
        Movie movie = movieService.getMovieById(movieId);
        if (movie != null) {
            FavoriteMovie favorite = new FavoriteMovie();
            favorite.setId(movie.getId());
            favorite.setTitle(movie.getTitle());
            favorite.setPosterPath(movie.getPosterPath());
            favoriteMovieRepository.save(favorite);
        }
        return "redirect:/favorites";
    }

    @GetMapping("/favorites")
    public String viewFavorites(Model model) {
        model.addAttribute("favorites", favoriteMovieRepository.findAll());
        return "favorites";
    }

    @PostMapping("/favorites/remove")
    public String removeFavorite(@RequestParam Long movieId) {
        favoriteMovieRepository.deleteById(movieId);
        return "redirect:/favorites";
    }
}
