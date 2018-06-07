package com.defaultpackage.server;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class represents the server's main thread. It accepts client connections
 * and starts communication between them.
 * @author Dushan Terzikj 30001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 07.04.2018
 */
public class Server{

    public static final int PORT = 9090;
    private ServerSocket serverSocket;
    private boolean running = true;

    /**
     * Public static method the prints an error message and exits the program
     * @param message
     */
    public static void printErrorMessage(String message){
        System.err.println(message);
        System.exit(1);
    }

    /**
     * Method which runs the server. It constantly accepts client connections
     * and runs them on a separate thread. 
     */
    public void runServer(String dirName){
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("The server directory " + dirName + " is up and running...");
            
            while(running){
                Socket socket = serverSocket.accept();
                new ServerConnection(socket, dirName).start();
            }

            serverSocket.close();
        } catch (IOException e) {
            printErrorMessage(e.getMessage());
        }
    }

    public static void main(String[] args) {
        if(args.length == 1){
            String dirName = args[0];
            File file = new File(dirName);
            if(!file.exists() || !file.isDirectory()){
                printErrorMessage("Directory does not exist!");
            }
            new Server().runServer(dirName);
        } else {
            printErrorMessage("Not enough arguments!");
        }
    }
}