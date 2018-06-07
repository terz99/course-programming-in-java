package com.defaultpackage.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ServerConnection extends Thread{

    Socket socket;
    Server server;
    DataInputStream dis;
    DataOutputStream dos;
    boolean shouldRun = true;

    public ServerConnection(Socket socket, Server server){
        super("ServerConnectionThread");
        this.socket = socket;
        this.server = server;
    }

    public void sendStringToClient(String text){
        try {
            dos.writeUTF(text);
            dos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendStringToAllClients(String text){
        for(int i = 0; i < server.connections.size(); i++){
            ServerConnection sc = server.connections.get(i);
            sc.sendStringToClient(text);
        }
    }

    @Override
    public void run() {
        try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
        
            while(shouldRun){
                while(dis.available() == 0){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String textIn = dis.readUTF();
                sendStringToAllClients(textIn);
            }

            dis.close();
            dos.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}