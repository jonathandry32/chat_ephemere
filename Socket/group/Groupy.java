package affichage;
import java.awt.*;
import javax.swing.*;
import outil.*;

public class Groupy extends JFrame{
    public void Anarana(){
        Forima pan=new Forima(this);
        this.add(pan.anarana());
        this.setTitle("index");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    public void Resaka(Clients client){
        Forima pan=new Forima(this);
        this.add(pan.sera(client));
        this.setTitle("chat");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}