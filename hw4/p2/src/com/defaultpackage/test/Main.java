package com.defaultpackage.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import com.defaultpackage.main.DataUtil;
import com.defaultpackage.main.QueryUtil;

public class Main{

    public static void main(String[] args) {
        
        Thread dataThread = new DataUtil();
        dataThread.start();
        try {
            dataThread.join();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        HashMap<String, String> data = DataUtil.countries;
    
        Scanner in = new Scanner(System.in);
        while(true){
            String country = in.nextLine();
            if(data.containsKey(country)){
                Thread t = new QueryUtil(country);
                t.start();
            } else if(country.toLowerCase().equals("quit")){
                break;
            } else {
                System.out.println("Country not found!");
            }
        }
        in.close();
        System.out.println("Bye!");
    }
}