/**
 * This is a class of a Cow. It is derived from Mammal.
 *
 * @author Dushan Terzikj
 * @since 03.03.2018
 * */
package com.mypackage.main;

public class Cow extends Mammal{

    /**
     * Default constructor for Cow. Calls super constructor and sets kind to cow.
     * */
    public Cow() {
        super();
        setKind("cow");
    }

    @Override
    /***
     * Method which returns a String statement
     * @return String statement of the sound which a cow makes
     */
    public String sound() {
        return "The sound I make is 'moo'.";
    }
}
