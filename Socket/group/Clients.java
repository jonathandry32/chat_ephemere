package outil;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.*;
import javax.swing.*;
import affichage.*;
public class Clients
{
    Socket socket; 
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;
    String name;

    public Clients(Socket socket,String name)throws Exception{
        this.socket=socket;
        this.name=name;
        this.bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void send(String messageToSend)throws Exception{
        bufferedWriter.write(messageToSend+" hoy i "+name);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }

    public void listenForMessage(Forima panel){
        new Thread(new Runnable(){
            public void run(){
                String messageFromGroupChat;
                while(socket.isConnected()){
                    try{
                        messageFromGroupChat=bufferedReader.readLine();
                        if(messageFromGroupChat.equals("")==false||messageFromGroupChat.equals(" ")==false||messageFromGroupChat.equals("  ")==false||messageFromGroupChat.equals("   ")==false){
                            panel.getTxt().append(messageFromGroupChat+"\n");
                        }
                    }
                    catch(Exception e){}
                }
            }
        }
        ).start();
    }
    public static void main(String[] args){
        new Groupy().Anarana();
    }
}