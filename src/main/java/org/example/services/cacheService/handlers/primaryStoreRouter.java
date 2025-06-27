package org.example.services.cacheService.handlers;

import org.example.models.FilterResult;
import org.example.models.User;

import java.util.List;

public class primaryStoreRouter implements baseRouter{
    private final baseRouter next;

    public primaryStoreRouter(baseRouter next){
        this.next = next;
    }

    @Override
    public List<FilterResult> getMovieList(User user, int listSize) {
        return List.of();
    }
}
