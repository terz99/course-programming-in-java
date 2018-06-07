/**
 * This is an abstract class which provides method for sorting the movies according
 * to some of its member variables.
 * @author Dushan Terzikj, Dragi Kamov, Sanjit Kunwar, Fanlin Wang
 * @since 16.03.2018
 * */
package com.mypackage.main;

public abstract class MovieServices {

    /**
     * This abstract method sorts the movies by their title
     * @param a a list of movies to be sorted
     * */
    public abstract void sortByTitle(Movie[] a);

    /**
     * This abstract method sorts the movies by their year of release
     * @param a a list of movies to be sorted
     * */
    public abstract void sortByYear(Movie[] a);

    /**
     * This abstract method sorts the movies by their score rating
     * @param a a list of movies to be sorted
     * */
    public abstract void sortByScore(Movie[] a);
}
