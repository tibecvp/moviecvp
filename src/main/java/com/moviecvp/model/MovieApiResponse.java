package com.moviecvp.model;

import lombok.Data;
import java.util.List;

@Data
public class MovieApiResponse {
    private List<Movie> results;
}
