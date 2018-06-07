/**
 * This class represents Ford. It extends the abstract class Auto.
 * @author Dushan Terzikj, Fanlin Wang, Sanjit Kunwar, Dragi Kamov
 * @since 17.03.2018
 * */
package terzikj.hw02.core.implementation;

import terzikj.hw02.core.Auto;

public class Ford extends Auto{

    /**
     * Default constructor. Sets the carMake to an empty
     * string and the price to $20k
     * */
    public Ford(){
        this.setCarMake("");
        this.setPrice();
    }

    /**
     * Parametrized constructor. Sets the car price to $20k
     * @param carMake the car make
     * */
    public Ford(String carMake){
        this.setCarMake(carMake);
        this.setPrice();
    }


    /**
     * Abstract setter for the price
     */
    @Override
    public void setPrice() {
        this.price = 20000.0;
    }
}
