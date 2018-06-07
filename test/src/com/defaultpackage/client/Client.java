package com.defaultpackage.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.defaultpackage.server.Server;

public class Client{

    public static final int PORT = 3333;

    Socket s;
    DataInputStream dis;
    DataOutputStream dos;

    public static void main(String[] args) {
        new Client();
    }

    public Client(){
        try {
            s = new Socket("localhost", PORT);
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());

            listenForInput();

            dis.close();
            dos.close();
            s.close();

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

            try {
                dos.writeUTF(input);

                while(dis.available() == 0){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                String reply = dis.readUTF();
                System.out.println(reply);
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
        in.close();
    }
}