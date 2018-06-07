package terzikj.hw02.core;

import terzikj.hw02.core.implementation.FederalState;

public class Main {

    public static void main(String args[]){

        FederalState[] federalStates = FederalState.getInstance();
        for(int i = 0; i < federalStates.length; i++){
            System.out.println(federalStates[i]);
        }
    }
}
