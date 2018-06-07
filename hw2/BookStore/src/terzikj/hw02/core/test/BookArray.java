package terzikj.hw02.core.test;

import terzikj.hw02.core.Book;
import terzikj.hw02.core.implementation.Fiction;
import terzikj.hw02.core.implementation.NonFiction;

import java.util.ArrayList;
import java.util.Random;

public class BookArray {

    public static void main(String args[]){

        ArrayList<Book> list = new ArrayList<Book>();
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            int op = random.nextInt(2);
            if(op == 0){
                list.add(new Fiction("Dude"));
            } else {
                list.add(new NonFiction("Sweet"));
            }
        }
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
