package com.example.test;

import com.example.main.Person;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * This class is a driver class for testing the Personal Address book.
 * @author Dushan Terzikj
 * @since 28.03.2018
 * */
public class Main {

    private static String instruction1 = "Please type (o) if you want to load an old file. " +
            "If not, type any character.";
    private static String instruction2 = "Enter (a) to add, (l) to lookup, (d) to delete, (e) to edit, " +
            "(s) to save, (h) for help, anything else to exit.";
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args){

        /* Here the user decides whether he wants to load an old file, or create a new */
        String filename = "";
        TreeMap<String, Person> addressBook = new TreeMap<String, Person>();
        System.out.println(instruction1);
        String op = in.next();
        switch (op){

            case "o":
                System.out.println("Please enter the file's name: ");
                filename = in.next();
                try {
                    FileInputStream fileInputStream = new FileInputStream(filename);
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    addressBook = (TreeMap<String, Person>) objectInputStream.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }

        /* Here the user interacts with the address book */
        System.out.println(instruction2);
        while(true){

            op = in.next();
            switch (op){
                case "a":
                    add(addressBook);
                    break;
                case "l":
                    lookup(addressBook);
                    break;
                case "e":
                    edit(addressBook);
                    break;
                case "d":
                    delete(addressBook);
                    break;
                case "s":
                    save(addressBook);
                    break;
                case "h":
                    System.out.println(instruction2);
                    break;
                default:
                    System.exit(0);
            }
            System.out.println(instruction2);
        }
    }

    /**
     * Saves a new entry into the addressBook TreeMap
     * @param addressBook the address book where the new entry is saved in
     * */
    private static void save(TreeMap<String, Person> addressBook) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
        int userSelection = fileChooser.showSaveDialog(null);
        if(userSelection == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + file.getAbsolutePath());
        }
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        String filename = fileChooser.getSelectedFile().getName();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(addressBook);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes an entry from the addressbook
     * @param addressBook the address book from where an entry is deleted
     * */
    private static void delete(TreeMap<String, Person> addressBook) {
        System.out.println("Who do you want to delete? Enter name: ");
        String name = in.next();
        if(addressBook.containsKey(name)){
            addressBook.remove(name);
        } else {
            System.out.println("Name not found!");
        }
    }

    /**
     * Edits an entry from the address book
     * @param addressBook the address book from where an entry is edited
     * */
    private static void edit(TreeMap<String, Person> addressBook) {
        System.out.println("Whose information you want to change? Enter name: ");
        String name = in.next();
        if(addressBook.containsKey(name)){
            addressBook.remove(name);
            add(addressBook);
        } else {
            System.out.println("Name not found!");
        }
    }

    /**
     * Looks up an entry in the address book and prints it in the console
     * @param addressBook the address book which is looked up
     * */
    private static void lookup(TreeMap<String, Person> addressBook) {
        System.out.println("Enter name: ");
        String name = in.next();
        if(addressBook.containsKey(name)){
            System.out.println(addressBook.get(name).toString());
        } else {
            System.out.println("Name not found!");
        }
    }

    /**
     * Adds a new entry into the address book
     * @param addressBook the entries are added in here
     * */
    private static void add(TreeMap<String, Person> addressBook) {
        System.out.println("Enter name: ");
        String name = in.next();
        System.out.println("Enter address: ");
        String address = in.next();
        System.out.println("Enter email: ");
        String email = in.next();
        System.out.println("Enter phone number: ");
        String number = in.next();
        long phoneNumber = Long.parseLong(number);
        Person p = new Person(name, address, email, phoneNumber);
        addressBook.put(p.getName(), p);
    }
}
