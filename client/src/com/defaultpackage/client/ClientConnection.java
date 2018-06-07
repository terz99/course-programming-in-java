package com.defaultpackage.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientConnection extends Thread{

    DataInputStream dis;
    DataOutputStream dos;
    Socket socket;
    Client client;
    boolean shouldRun = true;

    public ClientConnection(Socket socket, Client client){
        super("ClientConnectionThread");
        this.socket = socket;
        this.client = client;
    }

    public void sendStringToServer(String text){
        try {
            dos.writeUTF(text);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            this.close();
        }
        
    }

    @Override
    public void run() {
        try {
            dis = new DataInputStream(this.socket.getInputStream());
            dos = new DataOutputStream(this.socket.getOutputStream());
            while(shouldRun){
                try {
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
                    this.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            this.close();
        }
    }

    public void close(){
        try {
            dis.close();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}