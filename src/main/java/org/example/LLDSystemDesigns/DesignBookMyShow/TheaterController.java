package org.example.LLDSystemDesigns.DesignBookMyShow;

import org.example.LLDSystemDesigns.DesignBookMyShow.Enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheaterController {
    Map<City, List<Theater>> threaterMap;
    List<Theater> allTheaters;

    public TheaterController(){
        threaterMap = new HashMap<>();
        allTheaters = new ArrayList<>();
    }

    public Map<Theater, List<Show>> getAllShows(Movie movie, City city){
        Map<Theater, List<Show>> theaterVsShow = new HashMap<>();
        List<Theater> theaters = threaterMap.get(city);

        for(Theater theater: theaters){
            List<Show> giveMoviesShow = new ArrayList<>();
            List<Show>  shows = theater.getShows();
            for(Show show: shows){
                if(show.getMovie().getMovieId() == movie.getMovieId()){
                    giveMoviesShow.add(show);
                }
            }
            if(!giveMoviesShow.isEmpty()){
                theaterVsShow.put(theater, giveMoviesShow);
            }
        }
        return  theaterVsShow;
    }



    public void addTheater(City city,  Theater theater){
        if(threaterMap.isEmpty()){
            threaterMap = new HashMap<>();
        }
        List<Theater> theaters = null;
        if(!threaterMap.isEmpty() && threaterMap.containsKey(city)){
            theaters = threaterMap.get(city);
            if(theaters.isEmpty()){
                theaters = new ArrayList<>();
            }else if(!theaters.contains(theater)) {
                theaters.add(theater);
            }
        } else {
            theaters = new ArrayList<>();
            theaters.add(theater);
        }
        threaterMap.put(city, theaters);

        if(allTheaters.isEmpty()){
            allTheaters = new ArrayList<>();
            allTheaters.add(theater);
        }else{
            if(!allTheaters.contains(theater)){
                allTheaters.add(theater);
            }
        }
    }
}
