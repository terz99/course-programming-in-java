/**
 * This class implements the methods from the abstract class MovieServices.java
 * @author Dushan Terzikj, Dragi Kamov, Fanlin Wang, Sanjit Kunwar
 * @since 16.03.2018
 * */
package com.mypackage.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MovieSorter extends MovieServices{


    /**
     * This abstract method sorts the movies by their title
     *
     * @param a a list of movies to be sorted
     */
    @Override
    public void sortByTitle(Movie[] a) {
        if(a.length > 0){
            List<Movie> list = Arrays.asList(a);
            Collections.sort(list, new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return o1.getTitle().compareTo(o2.getTitle());
                }
            });
            a = list.toArray(new Movie[list.size()]);
        }
    }

    /**
     * This abstract method sorts the movies by their year of release
     *
     * @param a a list of movies to be sorted
     */
    @Override
    public void sortByYear(Movie[] a) {
        if(a.length > 0){
            List<Movie> list = Arrays.asList(a);
            Collections.sort(list, new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return o1.getYear() - o2.getYear();
                }
            });
            a = list.toArray(new Movie[list.size()]);
        }
    }

    /**
     * This abstract method sorts the movies by their score rating
     *
     * @param a a list of movies to be sorted
     */
    @Override
    public void sortByScore(Movie[] a) {
        if(a.length > 0){
            List<Movie> list = Arrays.asList(a);
            Collections.sort(list, new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return (int) (o1.getScore()*10 - o2.getScore()*10);
                }
            });
            a = list.toArray(new Movie[list.size()]);
        }
    }
}
