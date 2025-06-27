package org.example.services.cacheService.utils;

import org.example.models.Movie;

import java.util.*;

public class L2CacheList {
    private final int capacity;
    Map<Integer,DLLList> freqMap;
    Map<Movie, > l2Cache;
    private int minFreq;

    public L2CacheList(int capacity){
        this.capacity = capacity;
        minFreq = 0;
        freqMap = new HashMap<>();
        l2Cache = new HashMap<>();
    }

    public Optional<Movie> get(Movie movie){
        Movie
    }

    public void put(Movie movie){

    }

    public List<Movie> getAllMovies(){
        return new ArrayList<>(l2Cache.values());
    }

}
