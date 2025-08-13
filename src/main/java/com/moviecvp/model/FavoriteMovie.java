package com.moviecvp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class FavoriteMovie {
    @Id
    private Long id;
    private String title;
    @JsonProperty("poster_path")
    private String posterPath;
}
