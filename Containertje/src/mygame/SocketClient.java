/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author E alse
 */
public class SocketClient {
        private String hostname;
    private int port;
    Socket socketClient;

    public SocketClient(String hostname, int port){
        this.hostname = hostname;
        this.port = port;
    }

    public void connect() throws UnknownHostException, IOException{
        System.out.println("Attempting to connect to "+hostname+":"+port);
        socketClient = new Socket(hostname,port);
        System.out.println("Connection Established");
    }

    public void readResponse() throws IOException{
       String userInput;
       BufferedReader stdIn = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

       System.out.print("RESPONSE FROM SERVER:");
       while ((userInput = stdIn.readLine()) != null) {
           System.out.println(userInput);
       }
    }
    
    public void askForTime() throws IOException{
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
       writer.write("TIME?");
       writer.newLine();
       writer.flush();
    }
    
}
