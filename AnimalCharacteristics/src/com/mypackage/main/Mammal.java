/**
 * This is a class of a Mammal. It is derived from Animal.
 *
 * @author Dushan Terzikj
 * @since 03.03.2018
 * */
package com.mypackage.main;

public class Mammal extends Animal{

    /**
     * Default constructor for Mammal objects. Sets integument to hair.
     * */
    public Mammal() {
        super();
        setIntegument("hair");
    }

    @Override
    public String movement(boolean fast) {
        return super.movement(fast);
    }

    @Override
    public String sound() {
        return super.sound();
    }
}
