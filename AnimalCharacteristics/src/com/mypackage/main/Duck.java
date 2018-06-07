/**
 * This is a class of a Duck. It is derived from Bird.
 *
 * @author Dushan Terzikj
 * @since 03.03.2018
 * */
package com.mypackage.main;

public class Duck extends Bird {

    /**
     * Default constructor for Duck. Calls super constructor and sets kind to duck.
     * */
    public Duck() {
        super();
        setKind("duck");
    }

    /***
     * Method which returns a String statement
     * @return String statement of the sound which a duck makes
     */
    @Override
    public String sound() {
        return "The sound I make is 'quack'.";
    }
}
