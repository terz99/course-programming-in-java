/**
 * This is a class of a Bird. It is derived from Animal.
 *
 * @author Dushan Terzikj
 * @since 03.03.2018
 * */
package com.mypackage.main;

public class Bird extends Animal{

    /**
     * Default constructor. Sets the integument to feathers.
     * */
    public Bird() {
        super();
        setIntegument("feathers");
    }

    @Override
    /**
     * Returns a statement of bird's movement.
     * @param fast a boolean value stating whether the bird moves fast (true) or not (false)
     * @return String 'I fly.' if fast is true, 'I walk on two legs' otherwise
     * */
    public String movement(boolean fast) {
        return ((fast) ? "I fly." : "I walk on two legs.");
    }

    @Override
    public String sound() {
        return super.sound();
    }
}
