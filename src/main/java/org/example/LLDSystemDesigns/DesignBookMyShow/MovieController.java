package org.example.LLDSystemDesigns.DesignBookMyShow;

import org.example.LLDSystemDesigns.DesignBookMyShow.Enums.City;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<City, List<Movie>> moviesMap;
    List<Movie> allMovies;

    public  MovieController(){
        moviesMap = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    public List<Movie> getMoviesByCity(City city){
        return moviesMap.get(city);
    }

    public Movie getMoviesByName(String movieName){
        for(Movie movie : allMovies){
            if(movie.getMovieName().equals(movieName)){
                return movie;
            }
        }
        return null;
    }

    public void addMovies(City city,  Movie movie){
        if(moviesMap.isEmpty()){
            moviesMap = new HashMap<>();
        }
        List<Movie> movies = null;
        if(!moviesMap.isEmpty() && moviesMap.containsKey(city)){
             movies = moviesMap.get(city);
            if(movies.isEmpty()){
                movies = new ArrayList<>();
            }else if(!movies.contains(movie)) {
                movies.add(movie);
            }
        } else {
            movies = new ArrayList<>();
            movies.add(movie);
        }
        moviesMap.put(city, movies);

        if(allMovies.isEmpty()){
            allMovies = new ArrayList<>();
            allMovies.add(movie);
        }else{
            if(!allMovies.contains(movie)){
             allMovies.add(movie);
            }
        }
    }
}
