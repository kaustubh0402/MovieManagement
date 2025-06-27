package org.example.services.cacheService;

import org.example.models.CacheType;
import org.example.models.FilterResult;
import org.example.models.Movie;
import org.example.models.User;
import org.example.services.cacheService.utils.L1CacheList;
import org.example.services.filterService.Criteria;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class l1CacheService implements baseCache{
    private Map<User, L1CacheList> l1CacheAllUser;
    private int cacheHit;
    private final int l1CacheCapacity;

    public l1CacheService(){
        l1CacheAllUser = new HashMap<>();
        cacheHit = 0;
        l1CacheCapacity = 5;
    }

    @Override
    public void clearCache(){
        l1CacheAllUser = new HashMap<>();
    }

    @Override
    public void setCacheHit(int extraHits){
        this.cacheHit = this.cacheHit + extraHits;
    }

    @Override
    public int getCacheHit() {
        return cacheHit;
    }

    private L1CacheList getL1CacheByUser(User user){
        if (!l1CacheAllUser.containsKey(user)) {
            l1CacheAllUser.put(user,new L1CacheList(l1CacheCapacity));
        }

        return l1CacheAllUser.get(user);
    }

    public FilterResult getL1CacheSerachedMovie(User user, Criteria criteria, int listSize){
        L1CacheList currentL1 = getL1CacheByUser(user);
        List<Movie> l1CacheMoviesForUSer = currentL1.getAllMovies();
        List<Movie> l1CacheFoundNovies = criteria.satisfy(l1CacheMoviesForUSer);

        //set cache hits
        setCacheHit(l1CacheFoundNovies.size());

        //set newly hit movies in l1
        l1CacheFoundNovies.forEach(currentL1::put);

        return new FilterResult(CacheType.L1_CACHE,l1CacheFoundNovies.subList(0,Math.min(l1CacheFoundNovies.size(),listSize)));
    }

}
