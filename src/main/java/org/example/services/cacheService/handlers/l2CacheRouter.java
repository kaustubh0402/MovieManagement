package org.example.services.cacheService.handlers;

import org.example.models.FilterResult;
import org.example.models.User;
import org.example.services.filterService.Criteria;

import java.util.List;

public class l2CacheRouter implements baseRouter{
    private final baseRouter next;

    public l2CacheRouter(baseRouter next){
        this.next = next;
    }

    public FilterResult getCurrentLevelMovies(User user, Criteria criteria, int listSize) {
        return null;
    }

    @Override
    public List<FilterResult> getMovieList(User user, Criteria criteria, int listSize) {
        return List.of();
    }

    @Override

}
