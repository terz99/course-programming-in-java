/**
 * This class is a driver class to test the other classes in this project. It initializes a list of movies and then
 * sorts them by title, year and score.
 * @author Dushan Terzikj, Fanlin Wang, Dragi Kamov, Sanjit Kunwar
 * @since 16.03.2018
 * */
package com.mypackage.test;

import com.mypackage.main.Movie;
import com.mypackage.main.MovieSorter;

public class Main {

    public static void main(String args[]){

        Movie[] MOVIES = {
                new Movie("Terminator 2: Judgment Day", 1991, (float) 7.9),
                new Movie("Se7en", 1995, (float) 8.1),
                new Movie("Fargo", 1996, (float) 8.2),
                new Movie("2001: A Space Odyssey", 1968, (float) 8.3),
                new Movie("Aliens", 1986, (float) 8.2),
                new Movie("Truman Show, The", 1998, (float) 7.8),
                new Movie("Back to the Future", 1985, (float) 7.8),
                new Movie("Casablanca", 1942, (float) 8.8),
                new Movie("One Flew Over the Cuckoo''s Nest", 1975, (float) 8.7),
                new Movie("Good Will Hunting", 1997, (float) 7.9),
                new Movie("Fifth Element, The", 1997, (float) 7.0),
                new Movie("Twelve Monkeys", 1995, (float) 7.8),
                new Movie("Star Wars", 1977, (float) 8.8),
                new Movie("Shawshank Redemption, The", 1994, (float) 9.0),
                new Movie("Pulp Fiction", 1994, (float) 8.6),
                new Movie("Titanic", 1997, (float) 7.2),
                new Movie("Star Wars: Episode V - The Empire Strikes Back", 1980, (float) 8.6),
                new Movie("Usual Suspects, The", 1995, (float) 8.7),
                new Movie("Schindler''s List", 1993, (float) 8.8),
                new Movie("Saving Private Ryan", 1998, (float) 8.5),
                new Movie("Braveheart", 1995, (float) 8.3),
                new Movie("American Beauty", 1999, (float) 8.8),
                new Movie("Raiders of the Lost Ark", 1981, (float) 8.6),
                new Movie("Godfather, The", 1972, (float) 9.0),
                new Movie("Star Wars: Episode VI - Return of the Jedi", 1983, (float) 8.0),
                new Movie("Blade Runner", 1982, (float) 8.3),
                new Movie("Silence of the Lambs, The", 1991, (float) 8.5),
                new Movie("Forrest Gump", 1994, (float) 7.8),
                new Movie("Star Wars: Episode I - The Phantom Menace", 1999, (float) 7.3),
                new Movie("Sixth Sense, The", 1999, (float) 8.5),
                new Movie("Independence Day", 1996, (float) 6.0)
        };

        MovieSorter movieSorter = new MovieSorter();
        movieSorter.sortByTitle(MOVIES);
        System.out.println("Sorted by title:");
        for(int i = 0; i < MOVIES.length; i++){
            System.out.println(MOVIES[i]);
        }
        System.out.println("--------------------");


        movieSorter.sortByYear(MOVIES);
        System.out.println("Sorted by year:");
        for(int i = 0; i < MOVIES.length; i++){
            System.out.println(MOVIES[i]);
        }
        System.out.println("--------------------");


        movieSorter.sortByScore(MOVIES);
        System.out.println("Sorted by score:");
        for(int i = 0; i < MOVIES.length; i++){
            System.out.println(MOVIES[i]);
        }
        System.out.println("--------------------");
    }
}
