/**
 * This is a Tester class. It uses the following classes: Animal, Mammal, Bird, Cow and Duck.
 *
 * @author Dushan Terzikj
 * @since 03.03.2018
 * */
package com.mypackage.main.test;

import com.mypackage.main.Animal;
import com.mypackage.main.Cow;
import com.mypackage.main.Duck;

import java.util.ArrayList;
import java.util.Scanner;

public class AnimalStuff {

    public static void main(String args[]){

        ArrayList<Animal> myList = new ArrayList<Animal>();
        Scanner in = new Scanner(System.in);
        while(true){

            String kind;
            System.out.println("Enter what kind of animal you want " +
                    "('duck' or 'cow', 'q' to quit):");
            kind = in.next();
            if(kind.equals("q")){
                break;
            } else if(kind.equals("duck")){

                Duck duck1 = new Duck();
                Duck duck2 = (Duck) Animal.newInstance("duck");
                if(duck1.equals(duck2)){
                    System.out.println("The ducks are the same!");
                }
                System.out.println("duck1:");
                System.out.println(duck1);
                System.out.println("duck2:");
                System.out.println(duck2);
                myList.add(duck1);
            } else if(kind.equals("cow")){

                Cow cow1 = new Cow();
                Cow cow2 = (Cow) Animal.newInstance("cow");
                if(cow1.equals(cow2)){
                    System.out.println("The cows are the same!");
                }
                System.out.println("cow1:");
                System.out.println(cow1);
                System.out.println("cow2:");
                System.out.println(cow2);
                myList.add(cow1);
            } else {

                System.out.println("Invalid input. Try again!");
            }
        }
    }
}
