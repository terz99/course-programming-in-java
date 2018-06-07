package terzikj.hw02.core.test;

import terzikj.hw02.core.Book;
import terzikj.hw02.core.implementation.Fiction;
import terzikj.hw02.core.implementation.NonFiction;

public class UseBook {

    public static void main(String args[]){

        Fiction fictionBook = new Fiction("Dude");
        NonFiction nonFictionBook = new NonFiction("Sweet");
        System.out.println(fictionBook);
        System.out.println(nonFictionBook);
    }
}
