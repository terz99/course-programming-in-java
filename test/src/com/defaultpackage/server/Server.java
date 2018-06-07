package com.defaultpackage.server;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server{


    public static final int PORT = 3333;
    ServerSocket ss;
    Socket s;
    DataInputStream dis;
    DataOutputStream dos;

    public static void main(String[] args) {
        new Server();
    }

    public Server(){
        try {
            ss = new ServerSocket(PORT);
            s = ss.accept();
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());

            listenForData();

            s.close();
            ss.close();
            dis.close();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listenForData(){

        while(true){

            try {
                while(dis.available() == 0){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                String dataIn = dis.readUTF();

                dos.writeUTF(dataIn);

            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }
}