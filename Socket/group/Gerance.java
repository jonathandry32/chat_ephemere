package outil;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.io.*;

public class Gerance implements Runnable{
    Socket socket;
    public static ArrayList<Gerance> clients=new ArrayList<Gerance>(); 
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;
    String clientName;

    public Gerance(Socket socket)throws Exception{
        this.socket=socket;
        this.bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.clientName=bufferedReader.readLine();
        clients.add(this);
        new_co(clientName+" tonga");
    }

    public void run(){
        String messageFromClient;
        while(socket.isConnected())
        {
            try{
                messageFromClient=bufferedReader.readLine();
                new_co(messageFromClient);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void new_co(String message)throws Exception{
        for(Gerance client:clients){
            if(!client.clientName.equals(clientName)){
                client.bufferedWriter.write(message);
                client.bufferedWriter.newLine();
                client.bufferedWriter.flush();
            }
        }
    }
}