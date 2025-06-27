package org.example.services.cacheService.handlers;

import org.example.models.FilterResult;
import org.example.models.User;

import java.util.List;

public class finishRouter implements baseRouter{

    @Override
    public List<FilterResult> getMovieList(User user, int listSize){
        return List.of();
    }
}
