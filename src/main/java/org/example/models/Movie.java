package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private int movieId;
    private String title;
    private String genre;
    private int releaseYear;
    private double rating;

}
