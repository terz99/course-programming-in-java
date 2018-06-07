/**
 * This class represents an Auto. It has two member variables: the car make and
 * the car's price.
 * @author Dushan Terzikj, Fanlin Wang, Dragi Kamov, Sanjit Kunwar
 * @since 17.03.2018
 * */
package terzikj.hw02.core;

public abstract class Auto {

    private String carMake;
    protected double price;

    /* Getters and setters */

    /**
     * Getter for the car make.
     * @return the car make
     * */
    public String getCarMake() {
        return carMake;
    }

    /**
     * Setter for the car make
     * @param carMake the new car make
     * */
    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    /**
     * Getter for the price
     * @return the price of the car
     * */
    public double getPrice() {
        return price;
    }

    /**
     * Abstract setter for the price
     * */
    public abstract void setPrice();

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
        return this.carMake + " $" + this.price;
    }
}
