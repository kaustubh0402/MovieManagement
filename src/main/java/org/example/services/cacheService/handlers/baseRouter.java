package org.example.services.cacheService.handlers;

import org.example.models.FilterResult;
import org.example.models.User;
import org.example.services.filterService.Criteria;

import java.util.List;

public interface baseRouter {
    List<FilterResult> getMovieList(User user, Criteria criteria, int listSize);
    FilterResult getCurrentLevelMovies(User user, Criteria criteria, int listSize);
}
