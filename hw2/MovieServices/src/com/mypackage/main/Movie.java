/**
 * This class represents a Movie. It stores the title, year and score rating of
 * the movie
 * @author Dushan Terzikj, Fanlin Wang, Dragi Kamov, Sanjit Kunwar
 * @since 16.03.2018
 * */
package com.mypackage.main;

public class Movie {

    /* Title of the movie */
    private String title;
    /* Year that the movie was released */
    private int year;
    /* Score rating of the movie */
    private float score;

    /* Constructors */

    /**
     * Parametrized constructor.
     * @param title the title of the movie
     * @param year the year that the movie was released
     * @param score the score rating of the movie
     * */
    public Movie(String title, int year, float score) {
        this.title = title;
        this.year = year;
        this.score = score;
    }

    /* Setters and getters */

    /**
     * Getter for the title of the movie
     * @return String - the title of the movie
     * */
    public String getTitle() {
        return title;
    }

    /**
     * Setter of the movie
     * @param title the new title of the movie
     * */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter of the year that the movie was released
     * @return int - the year the movie was released
     * */
    public int getYear() {
        return year;
    }

    /**
     * Setter for the year of the movie
     * @param year the new year of the movie
     * */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Getter for the score rating of the movie
     * @return float - the score rating
     * */
    public float getScore() {
        return score;
    }

    /**
     * Setter for the score rating
     * @param score the new score rating
     * */
    public void setScore(float score) {
        this.score = score;
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return this.title + " " + this.year + " " + this.score;
    }
}
