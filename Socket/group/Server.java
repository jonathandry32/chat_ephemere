package outil;
import java.net.ServerSocket;
import java.net.Socket;
import affichage.*;
public class Server{
    ServerSocket serverSocket;
    int connected=0;

    public Server(ServerSocket serverSocket){
        this.serverSocket=serverSocket;
    }
    public void set_connected(){
        this.connected=this.connected+1;
    }
    public int get_connected(){
        return this.connected;
    }

    public void startServer()throws Exception{
        while(!serverSocket.isClosed()){
            Socket socket=serverSocket.accept();
            set_connected();
            Gerance client=new Gerance(socket);
            Thread thread=new Thread(client);
            thread.start();
        }
    }
    
    public static void main(String[] args)throws Exception{
        new Forima_s();
        ServerSocket serverSocket=new ServerSocket(0001);
        Server server=new Server(serverSocket);
        server.startServer();
    }
}