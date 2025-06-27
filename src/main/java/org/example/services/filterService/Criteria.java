package org.example.services.filterService;

import org.example.models.FilterResult;
import org.example.models.Movie;

import java.util.List;

public interface Criteria {
    List<Movie> satisfy(List<Movie> movieList);
}
