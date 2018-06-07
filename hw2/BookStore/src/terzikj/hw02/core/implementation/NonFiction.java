package terzikj.hw02.core.implementation;

import terzikj.hw02.core.Book;

public class NonFiction extends Book{

    /* Constructors */

    /**
     * Default constructor. It calls the super constructor
     * and sets the price of the book to 37.99
     * */
    public NonFiction(){
        super();
        this.setPrice();
    }

    /**
     * Parametrized constructor. It calls the super constructor
     * and sets the price of the book to 37.99
     * @param title the title of the book
     * */
    public NonFiction(String title){
        super(title);
        this.setPrice();
    }

    /* Setters and getters */

    /**
     * Abstract method which sets the price of the book
     */
    @Override
    protected void setPrice() {
        this.price = 37.99;
    }
}
