package org.example.services.cacheService.handlers;

import org.example.models.FilterResult;
import org.example.models.Movie;
import org.example.models.User;
import org.example.services.cacheService.baseCache;
import org.example.services.cacheService.l1CacheService;
import org.example.services.filterService.Criteria;

import java.util.ArrayList;
import java.util.List;

public class l1CacheRouter implements baseRouter{
    private final baseRouter next;
    private final l1CacheService cacheService;

    public l1CacheRouter(baseRouter next, l1CacheService cacheService){
        this.next = next;
        this.cacheService = cacheService;
    }

    @Override
    public FilterResult getCurrentLevelMovies(User user, Criteria criteria, int listSize) {
        return cacheService.getL1CacheSerachedMovie(user,criteria,listSize);
    }

    @Override
    public List<FilterResult> getMovieList(User user, Criteria criteria,int listSize) {
        List<FilterResult> allSearchResult = new ArrayList<>();
        FilterResult currentL1FilterResult = getCurrentLevelMovies(user,criteria,listSize);

        allSearchResult.add(currentL1FilterResult);
        int remainingSearch = listSize - currentL1FilterResult.getMovies().size();
        if(remainingSearch > 0) {
            List<FilterResult> fromNextStore = next.getMovieList(user, criteria, remainingSearch);
            allSearchResult.addAll(fromNextStore);
        }
        return allSearchResult;
    }



}
