package com.defaultpackage.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * This class represents a class which extends {@code Thread}. It collects the names of
 * all the countries on a separate thread.
 * @author Dushan Terzikj 30001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 11.04.2018
 */
public class DataUtil extends Thread{

    public static HashMap<String, String> countries;

    /**
     * Private method which connects to a specific URL and extracts data from an HTML file.
     * It extracts the names of the countries listed on the specific URL.
     * @throws IOException
     */
    private void getCountryNames() throws IOException{

        System.out.println("Connecting...");
        URL url = new URL("https://www.cia.gov/library/publications/the-world-factbook/print/textversion.html");
        URLConnection connection = url.openConnection();
        BufferedReader is = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        connection.connect();
        System.out.println("Connected.");

        System.out.println("Getting country names...");
        String line = "";
        final String FILTERSTR = "<option value=\"../geos/";
        while((line = is.readLine()) != null){
            if(line.toLowerCase().contains(FILTERSTR)){
                String key = line.substring(37, line.indexOf(" </option"));
                String value = line.substring(27, 34);
                countries.put(key.toLowerCase(), value);
            }
        }
        is.close();
        System.out.println("Done.");
    }

    @Override
    public void run() {
        countries = new HashMap<String, String>();
        try {
            System.out.println("Getting data...");
            getCountryNames();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            System.out.println("Data acquired.");
        }
    }
}