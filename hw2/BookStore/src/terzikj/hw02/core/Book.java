/**
 * This class represents a book. It has two member variables: the title of the book
 * and its price (double type).
 * @author Dushan Terzikj, Dragi Kamov, Fanlin Wang, Sanjit Kunwar
 * @since 17.03.2018
 * */
package terzikj.hw02.core;

public abstract class Book {

    private String title;
    protected double price;

    /* Constructors */

    /**
     * Default constructor
     * */
    public Book(){}

    /**
     * Parametrized constructor
     * @param title the title of the book
     * */
    public Book(String title){
        this.title = title;
    }

    /* Getters and setters */

    /**
     * Getter for the title of the book
     * @return the title of the book
     * */
    public String getTitle() {
        return title;
    }

    /**
     * Getter for the price of the book
     * @return the price of the book
     * */
    public double getPrice() {
        return price;
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
        return this.title + " $ " + this.price;
    }

    /**
     * Abstract method which sets the price of the book
     * */
    protected abstract void setPrice();
}
