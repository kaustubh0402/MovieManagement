package org.example.services.filterService;

import org.example.models.Movie;

import java.util.List;
import java.util.stream.Collectors;

public class GenreCriteria implements Criteria{
    private final String genre;

    public GenreCriteria(String genre){
        this.genre = genre;
    }

    @Override
    public List<Movie> satisfy(List<Movie> movieList){
        return movieList.stream()
                .filter(movie -> movie.getGenre().equalsIgnoreCase(this.genre))
                .collect(Collectors.toList());
    }
}
