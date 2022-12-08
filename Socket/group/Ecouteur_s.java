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
public class Ecouteur_s implements ActionListener{
    Forima_s forima_s;
    int co=0;
    public Ecouteur_s(Forima_s er){
        this.forima_s=er;
    }
    public void actionPerformed(ActionEvent e){
        co++;
        forima_s.set_error(co+" clients en ligne");
    }
}