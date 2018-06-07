package com.defaultpackage.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client{

    public static final int PORT = 3336;

    ClientConnection cc;

    public static void main(String[] args) {
        new Client();
    }

    public Client(){
        try {
            Socket s = new Socket("localhost", PORT);

            cc = new ClientConnection(s, this);
            cc.start();
            listenForInput();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listenForInput(){

        Scanner in = new Scanner(System.in);

        while(true){
            while(!in.hasNextLine()){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String input = in.nextLine();

            if(input.toLowerCase().equals("quit")){
                break;
            }

            cc.sendStringToServer(input);
        }
        in.close();
        cc.close();
    }
}