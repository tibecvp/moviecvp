package com.moviecvp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class FavoriteMovie {
    @Id
    private Long id;
    private String title;
    private String posterPath;
}
