package com.moviecvp.service;

import com.moviecvp.model.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class MovieService {

    @Value("${tmdb.api.key}")
    private String apiKey;

    @Value("${tmdb.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public MovieService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Movie> getTrendingMovies() {
        String url = apiUrl + "/trending/movie/week?api_key=" + apiKey;
        System.out.println("DEBUG: The URL being requested is : " + url);
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        return (List<Movie>) response.get("results");
    }

    public List<Movie> searchMovies(String query) {
        String url = apiUrl + "/search/movie?api_key=" + apiKey + "&query=" + query;
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        return (List<Movie>) response.get("results");
    }

    public Movie getMovieById(Long id) {
        String url = apiUrl + "/movie/" + id + "?api_key=" + apiKey;
        return restTemplate.getForObject(url, Movie.class);
    }
}
