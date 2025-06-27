package org.example.services.filterService;

import org.example.models.Movie;

import java.util.List;
import java.util.stream.Collectors;

public class ReleseYearCriteria implements Criteria{
    private final int releaseYear;

    public ReleseYearCriteria(int releaseYear){
        this.releaseYear = releaseYear;
    }

    @Override
    public List<Movie> satisfy(List<Movie> movieList){

        return movieList.stream()
                .filter(movie -> movie.getReleaseYear() == this.releaseYear)
                .collect(Collectors.toList());
    }

}
