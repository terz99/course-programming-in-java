/**
 * This class represents Ford. It extends the abstract class Auto.
 * @author Dushan Terzikj, Fanlin Wang, Sanjit Kunwar, Dragi Kamov
 * @since 17.03.2018
 * */
package terzikj.hw02.core.implementation;

import terzikj.hw02.core.Auto;

public class Chevy extends Auto{

    /**
     * Default constructor. Sets the carMake to an empty
     * string and the price to $22k
     * */
    public Chevy(){
        this.setCarMake("");
        this.setPrice();
    }

    /**
     * Parametrized constructor. Sets the car price to $22k
     * @param carMake the car make
     * */
    public Chevy(String carMake){
        this.setCarMake(carMake);
        this.setPrice();
    }

    /**
     * Abstract setter for the price
     */
    @Override
    public void setPrice() {
        this.price = 22000.0;
    }
}
