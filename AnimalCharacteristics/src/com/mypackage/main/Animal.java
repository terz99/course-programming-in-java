/**
 * This is a class of an Animal. It has two member variables: the kind of the animal and the integument of the animal.
 * This class cannot be used directly, but its derived/child classes can be used.
 *
 * @author Dushan Terzikj
 * @since 03.03.2018
 * */
package com.mypackage.main;

public class Animal {

    private String kind;
    private String integument;

    /**
     * Protected constructor. It cannot be used directly by the user. Instead the user uses the newInstance method
     * */
    protected Animal(){}

    /**
     * Method which returns a new type of Animal according to the parameter kind
     * @param kind String which indicates the type of the animal
     * @return Derived/child class of Animal depending on the parameter kind
     * */
    public static Animal newInstance(String kind){
        if(kind.equals("duck")){
            return new Duck();
        } else if(kind.equals("cow")){
            return new Cow();
        } else {
            return null;
        }
    }

    /**
     * Method which returns a statement
     * @param fast boolean which indicates whether the animal is moving fast (true) or not (false)
     * @return String statement about the current movement of the animal
     * */
    public String movement(boolean fast){
        return ((fast) ? "I run on four legs." : "I walk on four legs");
    }

    /**
     * Method which returns the sound that the animal makes
     * @return String statement stating the sound that the animal makes
     * */
    public String sound(){
        return "";
    }

    /**
     * Setter for integuement
     * @param integument the new integument
     * */
    public void setIntegument(String integument) {
        this.integument = integument;
    }

    /**
     * Setter for kind
     * @param kind the new kind
     * */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * Getter for kind
     * @return String - the kind of the animal
     * */
    public String getKind() {
        return kind;
    }

    /**
     * Getter for integument
     * @return String - the integument of the animal
     * */
    public String getIntegument() {
        return integument;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Cow){

            Cow cow = (Cow)obj;
            return cow.getKind().equals(this.kind)
                    && cow.getIntegument().equals(this.integument)
                    && cow.sound().equals(this.sound())
                    && cow.movement(true).equals(this.movement(true))
                    && cow.movement(false).equals(this.movement(false));
        } else if(obj instanceof Duck){

            Duck duck = (Duck)obj;
            return duck.getKind().equals(this.kind)
                    && duck.getIntegument().equals(this.integument)
                    && duck.sound().equals(this.sound())
                    && duck.movement(true).equals(this.movement(true))
                    && duck.movement(false).equals(this.movement(false));
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "I am a " + this.kind + "\n"
                + "I have " + this.integument + "\n"
                + "When I go slowly, " + this.movement(false) + "\n"
                + "When I go fast, " + this.movement(true) + "\n"
                + this.sound();
    }
}
