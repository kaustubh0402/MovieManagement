package org.example.services.cacheService.utils;

import org.example.models.Movie;

import java.util.*;

public class L1CacheList {
    private final int capacity;
    Map<Movie, movieNode> l1CacheMap;
    private final DLLList dllList;

    public L1CacheList(int capacity){
        this.capacity = capacity;
        l1CacheMap = new HashMap<>();
        dllList = new DLLList();
    }

    public Optional<Movie> get(Movie movie) {
        if(l1CacheMap.containsKey(movie))
        {
            movieNode curr=l1CacheMap.get(movie);
            dllList.remove(curr);
            dllList.add(curr);
            return Optional.of(curr.getMovie());
        }
        put(movie);
        return Optional.empty();

    }

    public void put(Movie movie) {
        if(l1CacheMap.containsKey(movie)) {
            dllList.remove(l1CacheMap.get(movie));
            l1CacheMap.remove(movie);
        }
        if(l1CacheMap.size()==this.capacity) {
            movieNode currRemoved = dllList.getTail().getPrev();
            dllList.remove(currRemoved);
            l1CacheMap.remove(currRemoved.getMovie());
        }
        movieNode newMovieNode = new movieNode(movie,null,null);
        dllList.add(newMovieNode);
        l1CacheMap.put(movie,newMovieNode);
    }


    public List<Movie> getAllMovies(){
        movieNode dummy = dllList.getHead().getNext();
        List<Movie>  currMovieList = new ArrayList<>();

        while(dummy!=null){
            currMovieList.add(dummy.getMovie());
            dummy = dummy.getNext();
        }
        return currMovieList;
    }

}
