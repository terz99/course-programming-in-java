package com.defaultpackage.server;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * This class represents a client-server connection. It is the stream
 * through which the client and the server communicate.
 * @author Dushan Terzikj 30001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 07.04.2018 
 */
public class ServerConnection extends Thread{

    private String dirName;
    private Socket socket;
    private BufferedReader bReader;
    private PrintWriter pWriter;
    private boolean running = true;

    /**
     * Default constructors. Accepts a socket and the server directory name
     * as arguments
     * @param socket
     * @param dirName
     */
    public ServerConnection(Socket socket, String dirName){
        this.socket = socket;
        this.dirName = dirName;
    }

    /**
     * This method is invoked when the client tpyes the command 'index'
     * It lists the files in server's directory and prints them on the client's screen
     */
    public void listFiles(){

        System.out.println("Listing files in file directory " + dirName);
        File[] files = new File(dirName).listFiles();
        if(files.length == 0){
            pWriter.println("Directory is empty!");
            pWriter.flush();
            return;
        }
        for(File f : files){
            if(f.isFile()){
                pWriter.println(f.getName());
                pWriter.flush();
            }
        }
    }

    /**
     * This is a helper method which copies a content of some {@code file} and 
     * sends the content to the client, which is then printed on his screen.
     * @param file the file which is being sent to the client
     */
    public void sendFileToClient(File file){
        try {
            BufferedInputStream bStream = new BufferedInputStream(new FileInputStream(file));
            int c;
            System.out.println("File copying has started...");
            pWriter.println("ok");
            pWriter.flush();
            while((c = bStream.read()) != -1){
                pWriter.write(c);
                pWriter.flush();
            }
            bStream.close();
            System.out.println("File copying finished!");
        } catch (IOException e) {
            Server.printErrorMessage(e.getMessage());
        }
    }

    /**
     * This method is invoked when the client sends 'get' command. It searches for a
     * file with specific {@code filename} and if exists, first it prints "ok" and then
     * the contents of the file. Otherwise, it prints "error" on the clients screen.
     * @param filename the file's name
     */
    public void sendFiles(String filename){

        System.out.println("Listing files in file directory " + dirName);
        System.out.println("Looking for a file " + filename);
        File[] files = new File(dirName).listFiles();
        if(files.length == 0){
            pWriter.println("error");
            pWriter.flush();
            return;
        }
        for(File f : files){
            if(f.isFile() && f.getName().equals(filename)){
                System.out.println("File has been found, sending to client...");
                sendFileToClient(f);
                return;
            }
        }
        pWriter.write("error");
        pWriter.flush();
    }

    @Override
    public void run() {
        
        try {
            
            bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pWriter = new PrintWriter(socket.getOutputStream(), true);

            while(running){

                System.out.println("Waiting for client input...");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    Server.printErrorMessage(e.getMessage());
                }

                String input = bReader.readLine();
                if(input == null) continue;
                input = input.trim();
                System.out.println("Incoming message from client: " + input);
                
                if(input.equals("quit")){
                    running = false;
                    continue;
                } else if(input.equals("index")){
                    listFiles();
                } else if(input.length() >= 3 && input.substring(0, 3).equals("get")){
                    sendFiles(input.substring(4));
                    running = false;
                }
            }

            bReader.close();
            pWriter.close();
            socket.close();
        } catch (IOException e) {
            Server.printErrorMessage(e.getMessage());
        }
    }
}