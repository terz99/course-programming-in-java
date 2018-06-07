package com.defaultpackage.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * This class represents a class which extends {@code Thread}. It is called everytime
 * the user queries about some country. It prints the population, GDP, Location, Area and 
 * capital city of some country
 * @author Dushan Terzikj 30001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 11.04.2018
 */
public class QueryUtil extends Thread{

    private String country;

    /**
     * Default constructor.
     * @param country name of the country which the user specified.
     */
    public QueryUtil(String country){
        this.country = country;
    }

    /**
     * Private method which connects to a specific URL where data regarding some {@code country}
     * is specified. The method reads and html file and looks for the specified {@code country}
     * When it finds it, it prints the population of that country on the screen
     * @param country the country which is specified
     * @throws IOException
     */
    private void getPopulation(String country) throws IOException{
        
        URL url = new URL("https://www.cia.gov/library/publications/the-world-factbook/fields/2119.html");
		URLConnection connection = url.openConnection();
		BufferedReader is = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        connection.connect();
        
        String line = "";
        String ret = null;
        while((line = is.readLine()) != null){
            String curr = country + "</td";
            if(line.toLowerCase().contains(curr.toLowerCase())){
                String tmp = is.readLine();
                ret = tmp.substring(0, tmp.indexOf("<br"));
            }
        }
        System.out.println("Population:\n\t" + ret);
    }

    /**
     * Private method which connects to a specific URL where data regarding some {@code country}
     * is specified. The method reads and html file and looks for the specified {@code country}
     * When it finds it, it prints the GDP of that country on the screen
     * @param country the country which is specified
     * @throws IOException
     */
    private void getGDP(String country) throws IOException{

        URL url = new URL("https://www.cia.gov/library/publications/the-world-factbook/fields/2195.html");
		URLConnection connection = url.openConnection();
		BufferedReader is = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        connection.connect();
        
        String line = "";
        String ret = null;
		while((line = is.readLine()) != null) {
			String curr = country + "</td";
			if(line.toLowerCase().contains(curr.toLowerCase())) {
				String tmp = is.readLine();
				ret = tmp.substring(0 , tmp.indexOf("<br"));
			}
        }
        System.out.println("GDP:\n\t" + ret);
    }

    /**
     * Private method which connects to a specific URL where data regarding some {@code country}
     * is specified. The method reads and html file and looks for the specified {@code country}
     * When it finds it, it prints the capital city of that country on the screen
     * @param country the country which is specified
     * @throws IOException
     */
    private void getCapitalCity(String country) throws IOException{

        URL url = new URL("https://www.cia.gov/library/publications/the-world-factbook/fields/2057.html");
		URLConnection connection = url.openConnection();
		BufferedReader is = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        connection.connect();
        
        String line = "";
        String ret = null;
		while((line = is.readLine()) != null) {
			String curr = country + "</td";
			if(line.toLowerCase().contains(curr.toLowerCase())) {
				String tmp = is.readLine();
				ret = "Name: " + tmp.substring(tmp.indexOf("</strong>") + 9 , tmp.indexOf("<br"));
				tmp = is.readLine();
				ret = ret + "\n\t" + "Geographic coordinates: " + tmp.substring(tmp.indexOf("</strong>") + 9 , tmp.indexOf("<br"));
				tmp = is.readLine();
				ret = ret + "\n\t" + "Time difference: " + tmp.substring(tmp.indexOf("</strong>") + 9 , tmp.indexOf("<br"));
			}
        }
        System.out.println("Capital City:\n\t" + ret);
    }

    /**
     * Private method which connects to a specific URL where data regarding some {@code country}
     * is specified. The method reads and html file and looks for the specified {@code country}
     * When it finds it, it prints the location of that country on the screen
     * @param country the country which is specified
     * @throws IOException
     */
    private void getLocation(String country) throws IOException{

        URL url = new URL("https://www.cia.gov/library/publications/the-world-factbook/fields/2144.html");
		URLConnection connection = url.openConnection();
		BufferedReader is = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        connection.connect();
        
        String line = "";
        String ret = null;
		while((line = is.readLine()) != null) {
			String curr = country + "</td";
			if(line.toLowerCase().contains(curr.toLowerCase())) {
				String tmp = is.readLine();
				ret = tmp.substring(0 , tmp.indexOf("<br"));
			}
        }
        System.out.println("Location:\n\t" + ret);
    }

    /**
     * Private method which connects to a specific URL where data regarding some {@code country}
     * is specified. The method reads and html file and looks for the specified {@code country}
     * When it finds it, it prints the area of that country on the screen
     * @param country the country which is specified
     * @throws IOException
     */
    private void getArea(String country) throws IOException{
        
        URL url = new URL("https://www.cia.gov/library/publications/the-world-factbook/fields/2147.html");
		URLConnection connection = url.openConnection();
		BufferedReader is = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        connection.connect();
        
        String line = "";
        String ret = null;
		while((line = is.readLine()) != null) {
			String curr = country + "</td";
			if(line.toLowerCase().contains(curr.toLowerCase())) {
				String tmp = is.readLine();
				ret = "Total: " + tmp.substring(tmp.indexOf("</strong>") + 9 , tmp.indexOf("<br"));
				tmp = is.readLine();
				ret = ret + "\n\t" + "Land: " + tmp.substring(tmp.indexOf("</strong>") + 9 , tmp.indexOf("<br"));
				tmp = is.readLine();
				ret = ret + "\n\t" + "Water: " + tmp.substring(tmp.indexOf("</strong>") + 9 , tmp.indexOf("<br"));
			}
        }
        System.out.println("Area:\n\t" + ret);
    }

    @Override
    public void run() {
        try {
            System.out.println("Getting data...");
            System.out.println("*** " + country.toUpperCase() + " ***\n");
            getPopulation(country);
            getGDP(country);
            getCapitalCity(country);
            getLocation(country);
            getArea(country);
            System.out.println("Done!");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}