package org.example.services.filterService;

import org.example.models.Movie;

import java.util.List;
import java.util.stream.Collectors;

public class AndFilterCriteria implements Criteria{
    List<Criteria> criteriaList;

    public AndFilterCriteria(List<Criteria> criteriaList){
        this.criteriaList = criteriaList;
    }

    @Override
    public List<Movie> satisfy(List<Movie> movieList){

        return movieList.stream()
                .filter(movie ->criteriaList.stream().noneMatch(
                        criteria -> criteria.satisfy(List.of(movie)).isEmpty()
                ))
                .collect(Collectors.toList());
    }
}
