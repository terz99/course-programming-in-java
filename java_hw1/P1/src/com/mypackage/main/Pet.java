package com.mypackage.main;

/**
* This is a class implementation of a pet. It has 3 member variables: name of the pet, 
* number of legs and type of the pet. This class is made for homework 1, problem 1.  
* @author Dushan Terzikj
* @since 01.03.2018
*/

public class Pet{

    private String name;
    private int numOfLegs;
    private String type;

    /** 
     * Default constructor. Initializes all member variables to 
     * either null, empty string or 0.
    */
    public Pet(){
        this.name = "";
        this.numOfLegs = 0;
        this.type = "";
    }

    /** 
     * Parametrized constructor.
     * @param name the name of the pet.
     * @param numOfLegs the number of legs the pet has.
     * @param type the type of the pet
    */
    public Pet(String name, int numOfLegs, String type){
        this.name = name;
        this.numOfLegs = numOfLegs;
        this.type = type;
    }

    /** 
     * Getter for the member variable name
    * @return String this.name 
    */
    public String getName(){
        return this.name;
    }

    /** 
     * Getter for member variable type
    * @return String this.type 
    */
    public String getType(){
        return this.type;
    }

    /** 
     * Getter for member variable numOfLegs
    * @return int this.numOfLegs 
    */
    public int getNumOfLegs(){
        return this.numOfLegs;
    }

    /**
     *  Setter for member variable name 
     * @param name the new name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Setter for member variable type
     * @param type the new type
     */
    public void setType(String type){
        this.type = type;
    }

    /**
     * Setter for member variable numOfLegs
     * @param numOfLegs the new number of legs
     */
    public void setNumOfLegs(int numOfLegs){
        this.numOfLegs = numOfLegs;
    }

    @Override
    /**
     * Calls super.equals(obj) if obj is not an instance of this
     * @param obj object which is compared to this
     * @return true if obj is equal to this, false otherwise
     */
    public boolean equals(Object obj){
        
        if(obj instanceof Pet){
            Pet pet = (Pet)obj;
            return (pet.name == this.name 
                && pet.numOfLegs == this.numOfLegs 
                && pet.type == this.type);
        }
        return super.equals(obj);
    }

    @Override
    /**
     * @return String representation of this
     */
    public String toString(){
        return "Name: " + this.name 
            + " Number of Legs: " + this.numOfLegs 
            + " Type: " + this.type;
    }
}