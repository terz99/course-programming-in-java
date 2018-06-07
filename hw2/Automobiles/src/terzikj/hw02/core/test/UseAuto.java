package terzikj.hw02.core.test;

import terzikj.hw02.core.implementation.Chevy;
import terzikj.hw02.core.implementation.Ford;

public class UseAuto {

    public static void main(String args[]){

        Ford ford = new Ford("Dude");
        Chevy chevy = new Chevy("Sweet");
        System.out.println(ford);
        System.out.println(chevy);
    }
}
