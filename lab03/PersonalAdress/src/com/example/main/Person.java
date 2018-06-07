
package com.example.main;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class represents a Person. It contains the name, address, email, website, notes and phone number of the person.
 * @author Dushan Terzikj
 * @since 27.03.2018
 * */
public class Person implements Serializable, Comparable<Person>{

    private String name;
    private String address;
    private String email;
    private long phoneNumber;

    /* Constructors and Desctructors */

    /**
     * Default constructor.
     * */
    public Person(){}

    /**
     * Parametrized constrcutor
     * @param name the name of the person
     * @param address the address of the person
     * @param email the email of the person
     * @param phoneNumber the phone number of the person
     * */
    public Person(String name, String address, String email, long phoneNumber) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /* Getters and Setters */

    /**
     * @return Persons' name
     * */
    public String getName() {
        return name;
    }

    /**
     * Set Person's name
     * @param name Person's new name
     * */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Persons' address
     * */
    public String getAddress() {
        return address;
    }

    /**
     * Set Person's address
     * @param address Person's new address
     * */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return Persons' email
     * */
    public String getEmail() {
        return email;
    }

    /**
     * Set Person's email
     * @param email Person's new email
     * */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return Persons' phone number
     * */
    public long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set Person's phone number
     * @param phoneNumber Person's new phone number
     * */
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /* Service and helper methods */

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
        return "Name: " + this.name
                + "\nAddress: " + this.address
                + "\nEmail: " + this.email
                + "\nPhone Number: " + this.phoneNumber;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * <p>
     * The {@code equals} method implements an equivalence relation
     * on non-null object references:
     * <ul>
     * <li>It is <i>reflexive</i>: for any non-null reference value
     * {@code x}, {@code x.equals(x)} should return
     * {@code true}.
     * <li>It is <i>symmetric</i>: for any non-null reference values
     * {@code x} and {@code y}, {@code x.equals(y)}
     * should return {@code true} if and only if
     * {@code y.equals(x)} returns {@code true}.
     * <li>It is <i>transitive</i>: for any non-null reference values
     * {@code x}, {@code y}, and {@code z}, if
     * {@code x.equals(y)} returns {@code true} and
     * {@code y.equals(z)} returns {@code true}, then
     * {@code x.equals(z)} should return {@code true}.
     * <li>It is <i>consistent</i>: for any non-null reference values
     * {@code x} and {@code y}, multiple invocations of
     * {@code x.equals(y)} consistently return {@code true}
     * or consistently return {@code false}, provided no
     * information used in {@code equals} comparisons on the
     * objects is modified.
     * <li>For any non-null reference value {@code x},
     * {@code x.equals(null)} should return {@code false}.
     * </ul>
     * <p>
     * The {@code equals} method for class {@code Object} implements
     * the most discriminating possible equivalence relation on objects;
     * that is, for any non-null reference values {@code x} and
     * {@code y}, this method returns {@code true} if and only
     * if {@code x} and {@code y} refer to the same object
     * ({@code x == y} has the value {@code true}).
     * <p>
     * Note that it is generally necessary to override the {@code hashCode}
     * method whenever this method is overridden, so as to maintain the
     * general contract for the {@code hashCode} method, which states
     * that equal objects must have equal hash codes.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     * @see #hashCode()
     * @see HashMap
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }

        if(!(obj instanceof Person)){
            return false;
        }

        Person other = (Person) obj;
        return this.name.equals(other.name)
                && this.email.equals(other.email)
                && this.address.equals(other.address)
                && Long.compare(this.phoneNumber, other.phoneNumber) == 0;
    }


    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     * <p>
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     * <p>
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     * <p>
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     * <p>
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     * <p>
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Person o) {
        if(o == this){
            return 0;
        }

        if(this.name.compareTo(o.name) == 0){
            if(this.address.compareTo(o.address) == 0){
                return this.email.compareTo(o.email); // no chance of same email address
            }
            return this.address.compareTo(o.address);
        }
        return this.name.compareTo(o.name);
    }
}
