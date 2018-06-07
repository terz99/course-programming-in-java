package com.defaultpackage.server;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Server{


    public static final int PORT = 3336;
    ServerSocket ss;
    boolean shouldRun = true;
    ArrayList<ServerConnection> connections = new ArrayList<ServerConnection>();

    public static void main(String[] args) {
        new Server();
    }

    public Server(){
        try {
            ss = new ServerSocket(PORT);
            while(shouldRun){
                Socket s = ss.accept();
                ServerConnection connection = new ServerConnection(s, this);
                connection.start();
                connections.add(connection);
            }
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}