package listener;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import javax.swing.*;
import java.net.ServerSocket;
import java.net.Socket;
import outil.*;
import affichage.*;

public class Ecouteur implements ActionListener
{
    Forima forima;
    Clients kil;
    BufferedWriter bufferedWriter;
    public Ecouteur(Forima forima){
        this.forima=forima;
    }
    public Ecouteur(Forima forima,Clients kil){
        this.forima=forima;
        this.kil=kil;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==forima.get_jb()){
            try{
                if(forima.get_jb().getText().equals("Eny")){
                    String username=forima.getTexte().getText();
                    Socket socket=new Socket("localhost",0001);
                    Clients kil=new Clients(socket,username);
                    forima.get_frame().hide();
                    this.bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    bufferedWriter.write(username+"\n");
                    bufferedWriter.flush();
                    new Groupy().Resaka(kil);
                }
                else if(forima.get_jb().getText().equals("Alefa")){
                    kil.send(forima.getTexte().getText());
                }
            }
            catch(Exception ee){
                System.out.println(ee.getMessage());
            }
        }
    }
}