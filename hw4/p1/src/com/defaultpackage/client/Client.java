package com.defaultpackage.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import com.defaultpackage.server.Server;

/**
 * This class represnets the client's main thread. From here, the client is
 * connecting to the server and then sends commands to it.
 * @author Dushan Terzikj 30001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 07.04.2018
 */
public class Client{

    private Socket socket;
    private BufferedReader bReaderClient;
    private BufferedReader bReaderServer;
    private PrintWriter pWriter;
    private boolean running = true;

    public static void main(String[] args) {
        new Client().runClientThread();
    }

    /**
     * Gets the server response. If {@code filename} is null, that means that is not
     * a 'get' command from the user. When it's {@code null} then the client just lists
     * and prints the files. If {@code filename} is not null, then it copies the corresponding 
     * content into a file and it also displays the content on the screen.
     * @param filename
     */
    public void getContent(String filename){
        try {
            String serverResponse = "";
            if(filename != null){
                PrintWriter fileWriter = new PrintWriter(filename);
                while(bReaderServer.ready() && (serverResponse = bReaderServer.readLine()) != null){
                    if(!serverResponse.equals("ok") && !serverResponse.equals("error")) fileWriter.println(serverResponse);
                    System.out.println(serverResponse);
                }
                fileWriter.close();
            } else {
                while(bReaderServer.ready() && (serverResponse = bReaderServer.readLine()) != null){
                    System.out.println(serverResponse);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Main method which runs the client's thread. It connects to a socket. It constantly waits for client's
     * console input and then sends the input to the server. After it sends it
     * the client might get a response from the server, depending on the type of the 
     * command he/she typed.
     */
    public void runClientThread(){
        try {

            socket = new Socket("localhost", Server.PORT);
            bReaderClient = new BufferedReader(new InputStreamReader(System.in));
            bReaderServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pWriter = new PrintWriter(socket.getOutputStream(), true);

            while(running){
                String input = bReaderClient.readLine();
                input = input.trim();
                pWriter.println(input);
                pWriter.flush();

                if(input.equals("quit")){
                    running = false;
                    continue;
                }

                try {
                    System.out.println("Waiting for server response...");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }

                if(input.equals("index")){
                    getContent(null);
                } else if(input.length() >= 3 && input.substring(0, 3).equals("get")){
                    getContent(input.substring(4));
                    running = false;
                }

                System.out.println("Server responded.");
            }
        
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}