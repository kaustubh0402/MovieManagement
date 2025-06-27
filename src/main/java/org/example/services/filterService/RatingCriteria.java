package org.example.services.filterService;

import org.example.models.Movie;
import org.example.services.filterService.factories.CompareFactory;
import org.example.services.filterService.stratergies.ComparisonStratergy;

import java.util.List;
import java.util.stream.Collectors;

public class RatingCriteria implements Criteria{


    private final double rating;
    private final ComparisonStratergy comparisonStratergy;

    public RatingCriteria(float rating, ComparisonStratergy comparisonStratergy){
        this.rating = rating;
        this.comparisonStratergy = comparisonStratergy;
    }

    @Override
    public List<Movie> satisfy(List<Movie> movieList){

        return movieList.stream()
                .filter(movie -> comparisonStratergy.compare(movie.getRating(),this.rating))
                .collect(Collectors.toList());
    }
}
